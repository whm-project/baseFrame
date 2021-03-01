// JavaScript Document
function menuMini(){
	if(document.getElementById("menu_div").className != "menuDiv_mini"){
		document.getElementById("menu_div").className  = "menuDiv_mini";
		document.getElementById("content_div").className  = "modularDiv_mini";
		document.getElementById("menu_state_btn").className  = "menubtn_zhankai";
	}else{
		document.getElementById("menu_div").className = "menuDiv";
		document.getElementById("content_div").className = "modularDiv";
		document.getElementById("menu_state_btn").className  = "menubtn_shousuo";
	}
}