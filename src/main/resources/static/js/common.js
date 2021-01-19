var arr2 = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
var arr3 = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];

function com_checkIdCard(idCardVal) {
    if (idCardVal.length == 18) {
        var arr = idCardVal.split('');
        var s;
        var reg = /^\d+$/;
        var pd = 0;
        for (i = 0; i < 17; i++) {
            if (reg.test(arr[i])) {
                s = true;
                pd = arr[i] * arr2[i] + pd;
            } else {
                s = false;
                break;
            }
        }
        if (s = true) {
            var r = pd % 11;
            if (arr[17] == arr3[r]) {
                return true;//合法身份证号码
            } else {
                return false;//非合法身份证号
            }
        }
    } else {
        return false;//非合法身份证号
    }
}