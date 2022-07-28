package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.exception.CodeNotFoundException;
import platform.model.Code;
import platform.repository.CodeRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static platform.service.Utils.getMSecondsFromDate;

@Service
public class CodeService {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    private void checkViewLimit(Code code) {
        System.out.println("Now Checking views count");
        if (code.getViews() == 0)
            return;

        code.setViews(code.getViews() - 1);

        if (code.getViews() == 0) {
            codeRepository.delete(code);
            System.out.println("Code deleted because of view count is 0 now");
        }

        else {
            codeRepository.save(code);
            System.out.println("Code saved with new views count = " + code.getViews());
        }
    }

    private void checkTimeLimit(Code code) {
        System.out.println("Now Checking lifetime");
        long lifeTime = code.getTime();
        if (lifeTime == 0)
            return;

        if (lifeTime > 0) {
            long currentSecond = System.currentTimeMillis() / 1000;
            long createdSecond = getMSecondsFromDate(code.getDate()) / 1000;
            long leftToLive = (createdSecond + lifeTime) - currentSecond;

            if (leftToLive > 0) {
                code.setTime(leftToLive);
                codeRepository.save(code);
                System.out.println("Code saved with new lifetime = " + leftToLive);
            } else {
                codeRepository.delete(code);
                System.out.println("Code Deleted. Out of time");
                throw new CodeNotFoundException();
            }
        }
    }

    public Code findByUUID(String uuid) {
        System.out.println("Looking for code with uuid=" + uuid);
        Optional<Code> code = codeRepository.findByUuid(uuid);
        if (code.isPresent()) {
            Code candidate = code.get();
            System.out.println("Code Found: " + candidate);
            checkViewLimit(candidate);
            checkTimeLimit(candidate);
            System.out.println("Returning Code: " + candidate);
            return candidate;
        }
        else throw new CodeNotFoundException();
    }

    public String addCode(Code code) {
        codeRepository.save(code);
        return code.getUuid();
    }

    public List<Code> getLastTen() {
        List<Code> result = codeRepository.findAllByOrderByDateDesc();

        Predicate<Code> notLimited = code -> ((code.getViews() == 0) && (code.getTime() == 0));
        return result.stream()
                .filter(notLimited)
                .limit(10L)
                .collect(Collectors.toList());
    }
}
