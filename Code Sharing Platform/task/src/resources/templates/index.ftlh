<!DOCTYPE html>
<html lang="en">
<head>
    <title>Code sharing platform</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
</head>
<body>
<div class="jumbotron col-sm-8 mx-auto mt-4">
    <h1 class="display-4">Code sharing platform</h1>
    <p class="lead">Web service to store syntax highlighted code snippets generating unique identifiers with the added possibility of configure its self-deletion based on time and views limitations.</p>
    <hr class="my-4">
    <div class="row">
        <div class="col">
            <a class="btn btn-primary btn-lg d-flex justify-content-center" href="http://localhost:8889/code/new" role="button">Create new snippet</a>
        </div>
        <div class="col">
            <a class="btn btn-primary btn-lg d-flex justify-content-center" href="http://localhost:8889/code/latest" role="button">See latest snippets</a>
        </div>
    </div>
</div>
</body>
</html>
