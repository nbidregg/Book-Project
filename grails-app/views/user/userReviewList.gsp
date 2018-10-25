<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Review List</title>
    <style>
    div.cent {
        text-align: center;
    }

    div.lef {
        text-align: left;
    }
    div.right{
        text-align: right;
    }

    h1 {
        font-size: 20pt;
    }

    h2 {
        font-size: 10pt;
    }
    </style>
</head>

<body><div class = cent>
<h1>Reviews by: ${user.username}</h1>
</div>
<g:each in="${reviews}" var="review" status="i">
    <h3>${i + 1}. <g:link controller="book" action="displayBook"
                          params="[author: review.getBook().author, title: review.getBook().title, reviews: reviews]">
        ${review.getBook().title}</g:link> : ${review.rating}</h3>

    <p>
        Comment:<br> ${review.comment} <br>

    </p>
    <br/>
</g:each>

<div class='cent'><br><g:form>
    <g:actionSubmit controller="book" action="index" value="Return to Books"/>
</g:form>
</div>
</body>
</html>