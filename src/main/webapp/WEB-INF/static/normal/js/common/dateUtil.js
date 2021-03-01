//年月日   日期转字符串  格式化
function setDateStrFormat(date){
    var yearStr = date.getFullYear();
    var monthStr = date.getMonth()+1;
    var dateStr = date.getDate();

    if(Number(monthStr) < 10){
        monthStr = "0" + monthStr;
    }
    if(Number(dateStr) < 10){
        dateStr = "0" + dateStr;
    }

    return yearStr+"-"+monthStr+"-"+dateStr;
}