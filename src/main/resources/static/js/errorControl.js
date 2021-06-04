let errCode = document.getElementById("errCode");
switch (Number(errCode.value)){
    case 11:
        alert("패스워드를 확인해주세요!");
        break;
    case 12:
        alert("중복된 아이디입니다!");
        break;
    default:
        break;
}