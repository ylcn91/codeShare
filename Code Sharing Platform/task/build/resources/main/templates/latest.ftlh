<!DOCTYPE html>
<html lang="en">
<head>
    <title>Latest</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<h1 class="col-sm-8 mx-auto mt-4">Latest snippets</h1>
<#if codeSnippets??>
    <#list codeSnippets as codeSnippet>
        <div class="col-sm-8 mx-auto mt-4 d-flex">
            <div class="card">
                <div class="card-body">
                    <span class="card-title" id="load_date">${codeSnippet.formattedDate}</span>
                    <pre id="code_snippet" class="card-text"><code>${codeSnippet.code}</code></pre>
                </div>
            </div>
        </div>
    </#list>
</#if>
</body>
</html>