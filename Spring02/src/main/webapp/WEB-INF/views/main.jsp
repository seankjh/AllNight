<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath() %>/resources/bootstrap/css/3-col-portfolio.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/bootstrap/css/full-slider.css"
	rel="stylesheet">

   <style>
  .carousel-inner > .item > .img, 
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Start Bootstrap</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">About</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Slider -->

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="http://220.121.93.213:8009/spring/image/main/1479112127598.jpg" alt="Chania" width="100%" height="345">
        <div class="carousel-caption">
          <h3>Chania</h3>
          <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
        </div>
      </div>

      <div class="item">
        <img src="http://220.121.93.213:8009/spring/image/main/1479112296130.jpg" alt="Chania" width="100%" height="345">
        <div class="carousel-caption">
          <h3>Chania</h3>
          <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
        </div>
      </div>
    
      <div class="item">
        <img src="http://220.121.93.213:8009/spring/image/main/1479112331541.jpg" alt="Flower" width="100%" height="345">
        <div class="carousel-caption">
          <h3>Flowers</h3>
          <p>Beatiful flowers in Kolymbari, Crete.</p>
        </div>
      </div>

      <div class="item">
        <img src="http://220.121.93.213:8009/spring/image/main/1479112127598.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <h3>Flowers</h3>
          <p>Beatiful flowers in Kolymbari, Crete.</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>



	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					상세페이지 <small>Secondary Text</small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">1번 상품 이름</a>
				</h3>
				<p>1번 상품 상세 설명</p>
			</div>
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">2번 상품 이름</a>
				</h3>
				<p>2번 상품 상세 설명</p>
			</div>
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">3번 상품 이름</a>
				</h3>
				<p>3번 상품 이름</p>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">4번 상품 이름</a>
				</h3>
				<p>4번 상품 상셍ㅁㄴㅇㄻㄴㅇㄹ</p>
			</div>
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
			</div>
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
			</div>
		</div>

		<!-- Projects Row -->
		<div class="row">
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
			</div>
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
			</div>
			<div class="col-md-4 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3>
					<a href="#">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
			</div>
		</div>
		<!-- /.row -->

		<hr>

		<!-- Pagination -->
		<div class="row text-center">
			<div class="col-lg-12">
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
		</div>
		<!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->


	   <!-- Script to Activate the Carousel -->
    <script type="text/javascript">
    	 $('.carousel').carousel({
    	        interval: 5000 //changes the speed
    	    })
    </script>
    
   

</body>

</html>
