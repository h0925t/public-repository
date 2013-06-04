<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/header.jsp"%>
<title>>突然の死<</title>
<script language="JavaScript">
	$(function() {
		$("#convert").on("click", function() {
			var input = $("#input").val();
			var param = {
				"input" : input
			};
			$.post("/api/totuzen", param, function(data, status) {
				if (data.status != "SUCCESS") {
					alert("ERROR！");
					return false;
				}
				var result = data.value;
				$("#output").val(result);
				reloadTweetBtn(result);
			});
		});
		$("#reset").on("click", function() {
			$("#input").val("");
			$("#output").val("");
		});
		var reloadTweetBtn = function(contents) {
			var a = $("<a/>");
			a.addClass("twitter-share-button");
			a.attr("href", "https://twitter.com/share");
			a.attr("data-text", contents);
			a.attr("data-lang", "ja");
			a.attr("data-size", "large");
			a.attr("data-count", "horizontal");
			a.attr("data-url", "");
			$("#tweetArea").html(a);
			twttr.widgets.load();
		}
	});
</script>

</head>
<body>
	<div class="container">
		<div class="span5">
			<h1>＞突然の死＜</h1>
			<div class="fields">
				<div class="title">
					<h2>変換前</h2>
				</div>
				<div class="input">
					<textarea id="input" class="span4"></textarea>
				</div>
			</div>
			<div class="">
				<input type="button" value="変換" id="convert"
					class="span3 btn btn-primary btn-large" /> <input type="button"
					value="リセット" id="reset" class="span2 btn btn-primary btn-large" />
			</div>
			<div class="fields">
				<div class="title">
					<h2>変換後</h2>
				</div>
				<div class="input">
					<textarea id="output" class="span4" readonly="readonly"></textarea>
				</div>
			</div>			
			<div id="tweetArea" class="row">
				<a href="https://twitter.com/share" class="twitter-share-button"
					data-text="" data-lang="ja" data-size="large">ツイート</a>
				<script>
					!function(d, s, id) {
						var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
								.test(d.location) ? 'http' : 'https';
						if (!d.getElementById(id)) {
							js = d.createElement(s);
							js.id = id;
							js.src = p + '://platform.twitter.com/widgets.js';
							fjs.parentNode.insertBefore(js, fjs);
						}
					}(document, 'script', 'twitter-wjs');
				</script>
			</div>
			<hr />
			<div class="row">
				<input type="button" value="戻る" id="reset"
					class="span1 btn" onclick="location.href='/<%=request.getContextPath() %>'"/>
			</div>
		</div>
	</div>
</body>
</html>