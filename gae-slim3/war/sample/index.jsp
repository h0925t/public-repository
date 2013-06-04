<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登録</title>
</head>
<body>
	<p>登録ページ</p>
	<form action="regist" method="post">
		<p>
			【タイトル】 <input type="text" name="title" />
		</p>
		<p>【内容】</p>
		<p>
			<textarea name="content"></textarea>
		</p>
		<input type="submit" value="regist" />
	</form>

	<c:forEach var="e" items="${sampleList}">
		${f:h(e.createdDate)}<br />
		${f:h(e.title)}<br />
		${f:h(e.content)}<br />
		<hr />
	</c:forEach>
</body>
</html>
