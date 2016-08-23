function checkMelliCode(varmellicode) {
    var melliCode;
    melliCode = varmellicode.value;
    if (melliCode.length == 10) {
        if (melliCode == '1111111111' ||
            melliCode == '0000000000' ||
            melliCode == '2222222222' ||
            melliCode == '3333333333' ||
            melliCode == '4444444444' ||
            melliCode == '5555555555' ||
            melliCode == '6666666666' ||
            melliCode == '7777777777' ||
            melliCode == '8888888888' ||
            melliCode == '9999999999') {
            alert("کد ملی صحیح نمی باشد");
            objcode.focus();
            return false;
        }
        c = parseInt(melliCode.charAt(9));
        n = parseInt(melliCode.charAt(0)) * 10 +
            parseInt(melliCode.charAt(1)) * 9 +
            parseInt(melliCode.charAt(2)) * 8 +
            parseInt(melliCode.charAt(3)) * 7 +
            parseInt(melliCode.charAt(4)) * 6 +
            parseInt(melliCode.charAt(5)) * 5 +
            parseInt(melliCode.charAt(6)) * 4 +
            parseInt(melliCode.charAt(7)) * 3 +
            parseInt(melliCode.charAt(8)) * 2;
        r = n - parseInt(n / 11) * 11;
        if ((r == 0 && r == c) || (r == 1 && c == 1) || (r > 1 && c == 11 - r) || (r > 1 && c == r)) {
            return true;
        } else {
            alert("کد ملی صحیح نمی باشد");
            objcode.focus();
            return false;
        }
    }
    else {
        alert("کد ملی باید ده رقمی باشد.");
        return false;
    }
}