function Member(){
  // 지역 변수를 밖에서 사용하는 방법 : 리턴을 받거나, var을 뺴거나, 속성 함수(getter setter)를 이용하거나
  var id = "admin";
  var pw = "hi123456";
  this.userid = id;   // 속성 생성
  this.userpw = pw;
  this._getId = function(){
    return id;
  };
  this._getPw = function(){
    return pw;
  };
  this._setId = function(x){
    id = x;
  };
  this._setPw = function(x){
    pw = x;
  }
}

function Board(){
  var title = "이것봐라";
  var content = "안녕";
  var writer = "왕곤듀";

  this._boardTitle = title;
  this._boardContent = content;
  this._boardWriter = writer;
  this._setTitle = function(x){
    title = x;
  }
  this._setContent = function(x){
    content = x;
  }
  this._setWriter = function(x){
    writer = x;
  }

  this._getTitle = function(){
    return title;
  }
  this._getContent = function(){
    return content;
  }
  this._getWriter = function(){
      return writer;
  }
}
