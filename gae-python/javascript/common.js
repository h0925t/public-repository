/**
 * @author Hitoshi Taniguchi
 */

var tweetTextarea = function(id) {
	var value = $("#" + id).val();
	if (value) {
		var tweet_url = "http://twitter.com/?status=" + value;
		window.open(tweet_url);
	} else {
		alert("Tweet内容が空です。");
	}
	return false;
}