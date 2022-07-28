<!DOCTYPE html>
<html lang="en">
<head>
    <title>Code</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<div class="col-sm-8 mx-auto mt-4 d-flex">
    <div class="card">
        <div class="card-body">
            <#if codeSnippet??>
                <span class="card-title" id="load_date">${codeSnippet.formattedDate}</span>
                <pre id="code_snippet" class="card-text"><code>${codeSnippet.code}</code></pre>
                <#if (codeSnippet.isViewRestricted())>
                    <span id="views_restriction">${codeSnippet.views} more views allowed</span>
                    <br>
                </#if>
                <#if (codeSnippet.isTimeRestricted())>
                    <span id="time_restriction">This code will be available for ${codeSnippet.timeAvailable} seconds</span>
                </#if>
            </#if>
        </div>
    </div>
</div>
</body>
</html>