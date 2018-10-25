<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Book Stuff</title>
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


<div class="cent">
    <h1 class="h1">${bookInstance.title}</h1>


    By: ${bookInstance.author}
    <br>
    Avg Rating: <g:formatNumber number="${(reviews.rating.sum() / reviews.size())}"
                                maxFractionDigits="1"/>
    <br>
    <g:form controller="review" action="addReview" params="[author: bookInstance.author, title: bookInstance.title]">
        <label>&nbsp;</label><input type="submit" value="Create Review">
    </g:form>
</div>

<h2 class="h2">Reviews:</h2>
<g:each in="${reviews}" var="review" status="i">
    <p>- ${review.comment}       <span style="color:green;">${review.rating}/5</span>
        <br>

        By
        <g:link controller="user" action="userReviewList"
                params="[username: review.getUser().username]">${review.getUser().username}</g:link>
    </p>
    <br/>
</g:each>
<div class='cent'><br><g:form>
    <g:actionSubmit action="index" value="Return to Books"/>
</g:form>
</div>
<br>


<br/>

</body>
</html>