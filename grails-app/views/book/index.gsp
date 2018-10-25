<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Books</title>
    <style>
    div.cent {
        text-align: center;
    }

    div.lef {
        text-align: left;
    }
    div.right {
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
<body>

<div class="cent"><h1>Reading List</h1></div>


<g:each in="${books}" var="book" status="i">
    <h3>${i + 1}.
    <g:link controller="book" action="displayBook"
            params="[author: book.author, title: book.title, reviews: book.reviews]">${book.title}</g:link>

    </h3>

    <p>
        By: ${book.author}, with ${book.reviews.size()} reviews
        <br>

    </p>
    <br/>
</g:each>

</body>
</html>