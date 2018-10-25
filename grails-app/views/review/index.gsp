<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Review List</title>
</head>

<body>
<p>This is merely a test I have ${reviews.size()} reviews</p>
<g:each in="${reviews}" var="review" status="i">
    <h3>${i + 1}. ${review.getBook().title}, ${review.rating}</h3>

    <p>
        Comments: ${review.comment} <br>

    </p>
    <br/>
</g:each>
</body>
</html>