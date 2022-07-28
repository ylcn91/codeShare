<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Create</title>
</head>
<body>
<h1 class="col-sm-8 mx-auto mt-4">New snippet</h1>
<div class="col-sm-8 mx-auto mt-4 d-flex">
    <div class="card" style="min-width: 100%">
        <div class="card-body">
            <form>
                <div class="form-group">
                    <textarea class="form-control" rows="5" id="code_snippet" placeholder="// write your code here"></textarea>
                </div>
                <div class="container">
                    <div class="row align-items-end">
                        <div class="col">
                            <label for="time_restriction">Expiration seconds:</label>
                            <input type="number" min="0" class="form-control" style="max-width: 120px" id="time_restriction">
                        </div>
                        <div class="col">
                            <label for="views_restriction">Expiration views:</label>
                            <input type="number" min="0" class="form-control" style="max-width: 120px" id="views_restriction">
                        </div>
                        <div class="col">
                            <div class="float-right">
                                <button id="send_snippet" type="submit" class="btn btn-primary btn-lg" onclick="send();">Save snippet</button>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    window.onload = function(){
                        document.getElementById("time_restriction").value=0
                        document.getElementById("views_restriction").value=0
                    };
                    function send() {
                        let object = {
                            "code": document.getElementById("code_snippet").value,
                            "time": document.getElementById("time_restriction").value,
                            "views": document.getElementById("views_restriction").value
                        };
                        let json = JSON.stringify(object);
                        let xhr = new XMLHttpRequest();
                        xhr.open("POST", '/api/code/new', false)
                        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                        xhr.send(json);
                        if (xhr.status === 200) {
                            let uuid = xhr.responseText.substring(6, xhr.responseText.length - 1);
                            alert("Success! new snippet: " + uuid);
                            window.open("http://localhost:8889/code/" + uuid.replace(/"/g, ""));
                        }
                    }
                </script>
            </form>
        </div>
    </div>
</div>
</body>
</html>