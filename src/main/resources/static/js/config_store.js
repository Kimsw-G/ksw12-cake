// vars
let result = document.querySelector('.result'),
    save = document.querySelector('.save'),
    cropped = document.querySelector('.cropped'),
    upload = document.querySelector('#file-input'),
    cropper = '';

upload.addEventListener('change', (e) => {
    if (e.target.files.length) {
        // start file reader
        const reader = new FileReader();
        reader.onload = (e)=> {
            if(e.target.result){
                // create new image
                // TODO : input 태그를 생성, 이 안에 file을 넣는 방법?!
                let inp = document.createElement('input');

                let img = document.createElement('img');
                img.id = 'image';
                img.src = e.target.result
                // clean result before
                result.innerHTML = '';
                // append new image
                result.appendChild(img);
                save.classList.remove('hide');
                // init cropper
                cropper = new Cropper(img);
                cropper.setAspectRatio(1);
            }
        };
        reader.readAsDataURL(e.target.files[0]);
    }
});


// 여기부터 내 코드
// let plus = document.getElementById("plus");

// plus.addEventListener('click',e=>{
//     return "";
// });