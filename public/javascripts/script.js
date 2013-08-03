var ehtml = ace.edit("editorHTML");
ehtml.getSession().setMode("ace/mode/html");

var ecss = ace.edit("editorCSS");
ecss.getSession().setMode("ace/mode/css");

var ejs = ace.edit("editorJS");
ejs.getSession().setMode("ace/mode/javascript");

$("#htmlHelper").val(ehtml.getSession().getValue());
ehtml.getSession().on('change', function(){
	$("#htmlHelper").val(ehtml.getSession().getValue());
});

$("#cssHelper").val(ecss.getSession().getValue());
ecss.getSession().on('change', function(){
	$("#cssHelper").val(ecss.getSession().getValue());
});

$("#jsHelper").val(ejs.getSession().getValue());
ejs.getSession().on('change', function(){
	$("#jsHelper").val(ejs.getSession().getValue());
});

$("#btnSave").click(function(){
	$("#fiddleForm").submit();
});

$("#btnDelete").click(function(){
	$("#fiddleFormDelete").submit();
});

function complete() {
	$('#load').fadeOut();
};
function run(){
	$('#load').show();
	var html = $("#htmlHelper").val();
	var css = $("#cssHelper").val();
	var js = $("#jsHelper").val();
	var iframe = $("#live");
	var data = iframe.contents();
	var body = data.find("body");
	var style =data.find("head").append("<style></style>").children("style");
	body.html(html)
	style.html(css);
	body.append("<script>parent.complete();"+js+"</script>")
}
run();
$("#btnRun").click(function(){
	run();
});