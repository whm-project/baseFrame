
//数字验证（null和''会作为数字0返回true）
function isNumeric(val) {
    if(isNaN(Number(val))){
        return false;
    }
    return true;
}

//手机号基本验证
function isPhoneNumber(phoneNum){
    if(!/^1[3-9]\d{9}$/.test(phoneNum)){
        return false;
    }else{
       return true;
    }
}

//车牌号验证 2018-12
function isVehicleNumber(vehicleNumber) {
    if(vehicleNumber.length == 7){
        var creg=/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1}$/;
        return creg.test(vehicleNumber);
    } else if(vehicleNumber.length == 8){
        var xreg=/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF]$)|([DF][A-HJ-NP-Z0-9][0-9]{4}$))/;
        return xreg.test(vehicleNumber);
    } else{
        return false;
    }
}