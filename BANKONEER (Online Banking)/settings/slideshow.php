<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../bankoneer/settings/slideshow.css">

</head>
<body>

<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/logo.png" width="1000" height="300" ">
  <div style="color:Black" class="text">BANKONEER | CORE BANKING SYSTEM SOFTWARE </div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/onlinebanking.jpg" width="1000" height="300" ">
  <div class="text">ONLINE BANKING WITH BANKONEER</div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/openaccount.jpg" width="1000" height="300" ">
  <div style="color:Black" class="text">OPEN BANK ACCOUTNT ONLINE</div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/online-shopping.png" width="1000" height="300" ">
  <div class="text">ONLINE PAYMENT THROUGH BANKONEER</div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/bc.jpg" width="1000" height="300" ">
  <div class="text">YOUR TRUSTED PLATFORM</div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/computeraccess.png" width="1000" height="300" ">
  <div style="color:Black" class="text">FULL ACCESS OF SERVICES PROVIDED BY BANK FROM ANYWHERE: REGISTER, LOGIN & ENJOY</div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/save.jpg" width="1000" height="300" ">
  <div class="text">SAVE BOTH MONEY AND TIME</div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/secured.jpg" width="1000" height="300" ">
  <div class="text">SECURED PAYMENT</div>
</div>
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="../bankoneer/images/download.jpg" width="1000" height="300" ">
  <div class="text">HAZZEL FREE PAYMENT AND ONLINE SURFING</div>
</div>




<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
</div>
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1} 
    slides[slideIndex-1].style.display = "block"; 
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>
</body>
</html> 
