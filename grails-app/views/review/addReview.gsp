<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Review List</title>
    <style>
    div.cent {
        text-align: center;
    }
        div.right{
            text-align: right;
        }
    </style>
</head>

<body>

<div class="cent">
    <h1>${book.title}</h1><br>

    <p>By: ${book.author}</p>

    <p><br><br>
    <fieldset>
        <legend>Review</legend>
        <g:form>
            <g:hiddenField name="title" value="${book.title}"/>
            <g:hiddenField name="author" value="${book.author}"/>
            <p>Rating:</p>
            <g:select name="rating" from="${1..5}"  style="width:200px;"/> <br>

            <g:textArea name="comment" style="width:400px; height: 200px;"/> <br>

            <g:actionSubmit action="saveReview" value="Save"/> &nbsp;
            <g:actionSubmit action="cancel" value="Cancel"/>
        </g:form>
    </fieldset>
</p>
</div>
</body>
</html>