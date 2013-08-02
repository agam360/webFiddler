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