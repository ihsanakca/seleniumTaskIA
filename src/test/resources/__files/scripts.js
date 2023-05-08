var globalCode = 87342546;
var globalEmail = "test@devskiller.com"
//Page1 - login
function loadPage1(){
    var timeout = Math.floor(Math.random() * (3000 - 500)) + 500; 
    setTimeout(function(){  
        $('#emailBox').attr("hidden",false);
    }, timeout);

    $('#emailBox').on("input", function(){
        if ($(this).val() == globalEmail){
            $(".buttonLogin").prop('disabled', false);
            $(".alogin").attr("href","#carouselExampleControls");
        }
        else{
            $(".buttonLogin").prop('disabled', true);
        }
    })

    $('#codeBox').on("input", function(){
        if ($(this).val() == globalCode){
            $(".buttonLoginCode").prop('disabled', false);
        }
        else{
            $(".buttonLoginCode").prop('disabled', true);
        }
    })
}
//Page 2 - login code

function loadPage2(){

}
//Page2 - code.html
function loadPageCode(){
    var timeout = Math.floor(Math.random() * (5000 - 1000)) + 1000; 
    setTimeout(function(){  
        $('#loader').remove();
        $('#code').val(globalCode);
        $('#code').attr("hidden",false);
    }, timeout);
}
//Page masked
function passwordField(number){
    return '<div class="col-1-auto align-items-center passwdDiv" id="div'+number+'">'+
    '<input class="passwdField" type="password" maxlength="1" id="passwd_'+number+'"">'+
    '<div class="w-100"></div>'+
    '<label class="passwdField horizontal-center" for="passwd_'+number+'">'+number+'</label>'+
    '</div>';
}

function generatePasswordBox(){
    var passwordInnerHtml="";
    for(i=0;i<10;i++){
        passwordInnerHtml += passwordField(i);
    }
    $('#passwordBox').html(passwordInnerHtml);
}

function loadPasswdFieldValues(){
    var passwdFieldValues= "";
  $(".passwdField").each(function(){passwdFieldValues += $(this).val();})
}

function verifyPasswd(){
    var passwd = "DevSkill1!";
    var passwdFieldValues= "";
  $(".passwdField:enabled").each(function(){passwdFieldValues += $(this).val();})
    if (passwdFieldValues == removeCharFrompPassword(passwd)){
        $("#loggedIn").html("You're logged IN!!");
    }
}

function removeCharFrompPassword(str){
    var arr = str.split('');

    arr[blockedField1] = '';
    arr[blockedField2] = '';
    arr[blockedField3] = '';

    return arr.join("");
}

function getRndInteger(min, max,except) {
    var result = except;
    do {
        result = Math.floor(Math.random() * (max - min)) + min;
    }while(result == except);
  return result;
}

var blockedField1;
var blockedField2;
var blockedField3;

function blockRandomField(){
    blockedField1 = getRndInteger(0,9);
    blockedField2 = getRndInteger(0,9,blockedField1);
    blockedField3 = getRndInteger(0,9,blockedField2);
    $("#passwd_"+blockedField1).prop("disabled",true);
    $("#passwd_"+blockedField2).prop("disabled",true);
    $("#passwd_"+blockedField3).prop("disabled",true);
}


function load(){
    // $('.buttonLogin').click(function(){
    //     verifyPasswd();
    // });
    $(".passwdField").keyup(function() {
        if (this.value.length == this.maxLength) {
            $(this).parent().nextAll(".passwdDiv").children('input:enabled:first').focus();
            loadPasswdFieldValues();
        }
    });
}