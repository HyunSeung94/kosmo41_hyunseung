<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="ko" style="height: auto;"><head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="No-Cache">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<!-- og:tag -->
<meta property="og:title" content="10월 할인 검색결과 - 스페이스클라우드">
<meta property="og:type" content="article">
<meta property="og:description" content="스터디룸, 세미나실, 오피스, 회의실, 파티룸까지 생활에 필요한 모임 &amp; 업무 공간을 스페이스클라우드에서 예약하세요!">

<meta property="og:image" content="https://scloud.pstatic.net/20170626_213/1498462883895nP5TK_JPEG/service_og.jpg">
<meta property="og:url" content="https://spacecloud.kr/search?q=10%EC%9B%94%ED%95%A0%EC%9D%B8">
<meta property="og:article:author" content="스페이스클라우드(SpaceCloud)">
<meta property="og:article:author:url" content="https://spacecloud.kr">
<!-- //og:tag -->
<meta name="description" content="스터디룸, 세미나실, 파티룸, 연습실까지! 우리에게 꼭 맞는 모임장소가 필요할 땐, 스페이스클라우드에서 공간을 예약해보세요.">
<title>스페이스클라우드 :: SpaceCloud</title>
<link rel="icon" href="https://ssl.pstatic.net/spacecloud/static/web/20180813/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="https://ssl.pstatic.net/spacecloud/static/web/20180813/spacecloud_icon.png" type="image/x-icon">
<link rel="apple-touch-icon" href="https://ssl.pstatic.net/spacecloud/static/web/20180813/spacecloud_icon.png">

<link rel="stylesheet" href="https://ssl.pstatic.net/spacecloud/static/web/css/deploy/20181023113009/min/guest.min.css" type="text/css">
<!--[if lt IE 10]>
	<link rel="stylesheet" href="https://ssl.pstatic.net/spacecloud/static/web/css/deploy/20181023113009/min/guestie9fix.min.css" type="text/css">
<![endif]-->




<script type="text/javascript">_headerRef = 'spacecloud.kr';</script>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-123322100-1"></script>
<script>
	var propertyId = "UA-123322100-1";

	window.dataLayer = window.dataLayer || [];
	function gtag(){dataLayer.push(arguments);}
	gtag('js', new Date());
	gtag('config', propertyId);
</script>
<style style="
    text-shadow: 0 0 black;
">
	*{margin:0;padding:0;}
	html,body{height:100%;width:100%;}
	#_container {/*display:table;*/}
	._layer{top:0;left:0;}
	._layerItem{display:none;position:fixed;z-index:9999;}
	._page {width:100%;height:100%;float:left;position:relative;}
</style></head>

<body class="pc">
<script src="https://ssl.pstatic.net/spacecloud/static/web/js/deploy/20181023113009/min/jquery.min.js" type="text/javascript"></script>
<ul id="u_skip">
	<li><a href="#content_wraper">컨텐츠 바로가기</a></li>
</ul>
<div class="wrap main" style="min-height: 911px; position: relative;">




    
        
        
            <div class="banner _enableEl" style="display: none;"></div>
        
    
    
    <header class="header header_main _enableEl fixed" style="margin-top: 0px; display: block;">
        <h1><a href="javascript:void(0);" class="logo _innerLink" direction="home"><i class="sp_icon ico_main_logo">SpaceCloud</i></a></h1>
        <nav class="main_menu_nav" role="navigation">
            <ul class="menu_list">
                <!-- [D] 메뉴 활성화 시, 클래스 active 추가 -->
                <li class="menu_item active"><a href="javascript:void(0)" class="_tab_header_btn" id="_first_tab_btn" data-tab-index="first">추천공간/리뷰</a></li>
                <li class="menu_item"><a href="javascript:void(0)" class="_tab_header_btn" id="_second_tab_btn" data-tab-index="second">써 본 사람</a></li>
                <li class="menu_item"><a href="javascript:void(0)" class="_tab_header_btn" id="_third_tab_btn" data-tab-index="third">기획전</a></li>
                <li class="menu_item btn_link_host"><a href="http://partner.spacecloud.kr" target="_blank">공간등록하기</a></li>
            </ul>
        </nav>
        <!-- [D] nav_search 클릭 시, header에 bar_open 클래스 추가해주세요 -->
        <a href="javascript:void(0)" class="nav_search" role="button"><i class="sp_icon ico_main_search">검색</i></a>
    
        <div class="section_search" style="">
            <div class="search_area">
                <!-- [D] btn_close 클릭 시, header에 bar_open 클래스 제거하고, bar_close 클래스 추가해주세요 -->
                <a href="#" class="btn_close" role="button">
                    <span class="sp_icon ico_btn_close">검색닫기</span>
                </a>
                <div class="input_wrap">
                    <form action="/search">
                        <label for="input_search">공간 검색</label>
                        <input type="text" name="q" id="input_search" class="input_search" placeholder="공간을 빠르게 검색해보세요" autocomplete="off">
                        <a href="#" class="btn_search" role="button">
                            <span class="sp_icon ico_search_input"></span>
                        </a>
                    </form>
                </div>
                
                <div class="search_box">
                    <p class="search_title">유형별로 찾아보기</p>
                    <ul class="check_list space categoryKeyword">
                    </ul>
                </div>
                
                <div class="search_box">
                    <p class="search_title">핫플레이스로 찾아보기</p>
                    <ul class="check_list space hotPlaceKeyword">
                    </ul>
                </div>
                
                <div class="search_box">
                    <p class="search_title">지하철역으로 찾아보기</p>
                    <ul class="check_list space subwayKeyword">
                    </ul>
                </div>
                
                <div class="search_box">
                    <p class="search_title">뜨는 동네로 찾아보기</p>
                    <ul class="check_list space risingPlaceKeyword">
                    </ul>
                </div>
            </div>
        </div>
        <a href="javascript:void(0);" class="nav_menu"> <i class="sp_icon ico_menu">전체메뉴</i></a>
    </header>
    
    <header class="header header_title _enableEl bar_close" style="display: none;">
    	<h1><a href="javascript:void(0);" class="logo _innerLink" direction="home"><i class="sp_icon ico_main_logo">SpaceCloud</i></a></h1>
    	<div class="page_title"><h2></h2></div>
		<a href="javascript:void(0);" class="nav_prev"><span class="sp_icon ico_prev">이전</span></a>
        <!-- [D] nav_search 클릭 시, header에 bar_open 클래스 추가해주세요 -->
        <a href="javascript:void(0)" class="nav_search" role="button"><i class="sp_icon ico_main_search">검색</i></a>
    
        <div class="section_search" style="">
            <div class="search_area" style="">
                <!-- [D] btn_close 클릭 시, header에 bar_open 클래스 제거하고, bar_close 클래스 추가해주세요 -->
                <a href="#" class="btn_close" role="button">
                    <span class="sp_icon ico_btn_close">검색닫기</span>
                </a>
                <div class="input_wrap">
                    <form action="/search">
                        <label for="input_search">공간 검색</label>
                        <input type="text" name="q" id="input_search" class="input_search" placeholder="공간을 빠르게 검색해보세요" autocomplete="off">
                        <a href="#" class="btn_search" role="button">
                            <span class="sp_icon ico_search_input"></span>
                        </a>
                    </form>
                </div>
                
                <div class="search_box">
                    <p class="search_title">유형별로 찾아보기</p>
                    <ul class="check_list space categoryKeyword">
                    </ul>
                </div>
                
                <div class="search_box">
                    <p class="search_title">핫플레이스로 찾아보기</p>
                    <ul class="check_list space hotPlaceKeyword">
                    </ul>
                </div>
                
                <div class="search_box">
                    <p class="search_title">지하철역으로 찾아보기</p>
                    <ul class="check_list space subwayKeyword">
                    </ul>
                </div>
                
                <div class="search_box">
                    <p class="search_title">뜨는 동네로 찾아보기</p>
                    <ul class="check_list space risingPlaceKeyword">
                    </ul>
                </div>
            </div>
        </div>
        <a href="javascript:void(0);" class="nav_menu"> <i class="sp_icon ico_menu">전체메뉴</i></a>
    </header>


<aside id="all_menu" class="drawer" role="navigation">
		<h2 class="blind">메뉴 영역</h2>
		<div class="scroll_wrap">
			<div class="scroll_inner">
				<article class="profile" id="_drawerProfile" style="">
					<!-- [D] ie8인 경우 img 태그로 대체 -->
					<div class="profile_ie">
						<img alt="프로필 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" style="display:none;">
					</div>
					<dl>
						<!-- <dt><strong>관리자명이요</strong></dt> -->
						<!-- [D]로그인 전일 경우 class="require_login" 추가 -->
						<dt class="require_login" id="_profileText">
							<strong>로그인이 필요합니다.</strong>
						</dt>
						<!-- [D] 프로필 사진이 없는 경우 -->
						<!-- <dd class="profile_img"><a href="javascript:void(0);" title="사진등록">프로필사진등록</a></dd> -->
						<!-- [D] 프로필 사진이 있는 경우 -->
						<dd class="profile_img">
							<a href="javascript:void(0);" title="프로필 페이지로 이동">프로필사진</a>
						</dd>
						<!--<dd class="profile_txt">파티하우스 루이파티하우스 루이의 관리자 입니다. 톡톡하기나 전화하기로 연락주세요연락주세요연락주세요</dd>-->
					</dl>
					<span class="profile_dim"></span>
				</article>
				<div class="scroll">
					<div class="menu_top">
						<ul>
							<li>
								<a href="/reserve/list">
									<i class="sp_icon ico_reservationlist"></i>
									<span class="tit">예약 리스트</span>
								</a>
							</li>
							<li>
								<a href="/my/review">
									<i class="sp_icon ico_manage"></i>
									<span class="tit">이용후기 / Q&amp;A관리</span>
									<span id="_drawerNewCommentMarker" class="case" style="display:none;">
										<i class="sp_icon ico_new">NEW</i>
									</span>
								</a>
							</li>
						</ul>
						<a href="/mycredit" class="credit_wrap">
	 						<div class="title">
	 							보유 크레딧
	 							<span class="link_more">자세히 보기</span>
	 						</div>
	 						<em class="total_credit"><i class="sp_icon ico_credit_small"></i><span id="_totalCrdAmt"></span></em>
	 					</a>
					</div>
					<!-- [D] gnb 높이 스크립트 필요( 길경우 스크롤생기도록 css처리)-->
					<nav id="gnb">
						<h3 class="blind">주메뉴 리스트</h3>
						<ul>
							<li><a href="/" class="depth_1 nclk" _nclk="mym.home">스페이스클라우드 홈</a></li>
							<li><a href="/space/zzim" class="depth_1 nclk" _nclk="mym.zzim">내가 가고 싶은 공간</a></li>
							<li><a href="https://talk.naver.com/" target="_blank" class="depth_1 nclk" _nclk="mym.talktalk">네이버 톡톡 대화 내역</a></li>
							<li><a href="/board/notice" class="depth_1 nclk" _nclk="mym.notice">공지사항</a></li>
							<li><a href="/board/help" class="depth_1 nclk" _nclk="mym.help">도움말</a></li>
							<li><a href="https://talk.naver.com/ct/wc89we" target="_blank" class="depth_1 nclk" _nclk="mym.sctalk">1:1문의</a></li>
							<li><a href="javascript:void(0);" class="depth_1 folded nclk" _nclk="mym.info">서비스 정보</a>
								<div>
									<ul class="depth_2">
										<li><a href="/introduction" class="nclk" _nclk="mym.introduction">서비스 소개</a></li>
										<li><a href="/agreement" class="nclk" _nclk="mym.agreement">이용약관</a></li>
										<li><a href="/policyPerson" class="nclk" _nclk="mym.privacy">개인정보처리방침</a></li>
										<li><a href="/policyOperate" class="nclk" _nclk="mym.policy">운영정책</a></li>
										
										<li><a href="/member/marketingAgree">마케팅 수신 동의 관리</a></li>
										<li><a href="/member/leave" class="nclk" _nclk="mym.withdraw">서비스 탈퇴</a></li>
										

									</ul>
								</div>
							</li>
						</ul>
						<div class="service_menu">
							
							
								<a href="javascript:void(0);" id="_logout" class="nclk" _nclk="mym.flogout">로그아웃</a>
							
							<p class="copyright">
								Powered by NAVER © NSPACE Corp.
							</p>
						</div>
					</nav>
				</div>
				<a href="javascript:void(0);" class="nav_menu_close"><i class="sp_icon ico_nav_close">메뉴 닫기</i></a>
			</div>
			<a href="http://partner.spacecloud.kr" class="btn_fixed_guest nclk" _nclk="mym.submit">호스트센터로 이동<i class="sp_icon ico_go"></i></a>
			<div class="scroll_out"></div>
		</div>
	</aside>
	<!-- //gnb -->
	<div id="_root" style="overflow: hidden; width: 100%;"> 
		<div id="_container" style="width: 2304px; left: 0px;">
			<div id="home" _path="/index" _position="0" _fit="false" _firstposition="[0, 0]" _reload="false" class="_page" style="width: 768px; visibility: visible;"> 
 
    
 
 






<style>

</style>
<div id="content_wraper" role="main">
	<div class="section_cont main_cont">
	<section class="slide_wrap">
		<h2 class="blind">배너</h2>
		<div id="scrollerWrap">
			<div id="scroller" style="overflow: hidden;">
				<ul class="slides" id="_bannerList" style="width: 2316px; transform: translateZ(0px) translateX(-153.563px);">
					
					
						<li class="slide" style="width: 386px;">
							
								
								<!-- PC -->
									<span style="background-image: url(https://scloud.pstatic.net/20181022_32/1540192444065z9Rpc_PNG/20181022_main_banner_pc.png);" class="img lazy"></span>
								
							
							<a href="https://spacecloud.kr/search/pick/806" class="inner nclk" _nclk="con.banner" _ncid="807" _nrank="1">
								<div class="inner_cell">
									<h3 class="h_promt">워크숍 장소 기획전</h3>
									<p class="tit_promt">
										<span class="quote">힙한 워크샵 공간<br>
여기 다 모였다!</span>
									</p>
									<span class="btn_opacity">바로가기</span>
								</div>
							</a>
						</li>
					
						<li class="slide active" style="width: 386px;">
							
								
								<!-- PC -->
									<span style="background-image: url(https://scloud.pstatic.net/20181015_23/1539569541374dWpEB_PNG/20181015_main_banner_pc1.png);" class="img lazy"></span>
								
							
							<a href="https://spacecloud.kr/search/pick/803" class="inner nclk" _nclk="con.banner" _ncid="804" _nrank="2">
								<div class="inner_cell">
									<h3 class="h_promt">중간고사 완벽대비</h3>
									<p class="tit_promt">
										<span class="quote">하루종일 집중하기 좋은<br>
스터디 공간 모음</span>
									</p>
									<span class="btn_opacity">바로가기</span>
								</div>
							</a>
						</li>
					
						<li class="slide" style="width: 386px;">
							
								
								<!-- PC -->
									<span style="background-image: url(https://scloud.pstatic.net/20181008_45/1538969475137cmPxd_PNG/20181008_main_banner_pc4.png);" class="img lazy"></span>
								
							
							<a href="https://spacecloud.kr/search/pick/800" class="inner nclk" _nclk="con.banner" _ncid="801" _nrank="3">
								<div class="inner_cell">
									<h3 class="h_promt">축가 연습 공간</h3>
									<p class="tit_promt">
										<span class="quote">결혼식 축가 연습을 위한<br>
연습실 공간 모음</span>
									</p>
									<span class="btn_opacity">바로가기</span>
								</div>
							</a>
						</li>
					
						<li class="slide" style="width: 386px;">
							
								
								<!-- PC -->
									<span style="background-image: url(https://scloud.pstatic.net/20181008_49/1538965236323Dhtff_PNG/20181008_main_banner_pc2.png);" class="img lazy"></span>
								
							
							<a href="https://spacecloud.kr/search?q=10%EC%9B%94%ED%95%A0%EC%9D%B8" class="inner nclk" _nclk="con.banner" _ncid="794" _nrank="4">
								<div class="inner_cell">
									<h3 class="h_promt">10월 할인 공간 모음</h3>
									<p class="tit_promt">
										<span class="quote">지금, '할인 이벤트'하는<br>
공간들을 만나보세요!</span>
									</p>
									<span class="btn_opacity">바로가기</span>
								</div>
							</a>
						</li>
					
						<li class="slide" style="width: 386px;">
							
								
								<!-- PC -->
									<span style="background-image: url(https://scloud.pstatic.net/20180508_44/1525747723251sjQac_PNG/170707_workspace_banner_pc.png);" class="img lazy"></span>
								
							
							<a href="https://spacecloud.kr/search/pick/641" class="inner nclk" _nclk="con.banner" _ncid="689" _nrank="5">
								<div class="inner_cell">
									<h3 class="h_promt">원데이노마드 기획전</h3>
									<p class="tit_promt">
										<span class="quote">디지털 노마드처럼<br>
자유롭게 일해보세요!</span>
									</p>
									<span class="btn_opacity">바로가기</span>
								</div>
							</a>
						</li>
					
						<li class="slide" style="width: 386px;">
							
								
								<!-- PC -->
									<span style="background-image: url(https://scloud.pstatic.net/20180528_277/1527488268392w0cHM_PNG/170602_main_banner_pc_2.png);" class="img lazy"></span>
								
							
							<a href="http://spacecloudevent.kr/workshop/" class="inner nclk" _nclk="con.banner" _ncid="710" _nrank="6">
								<div class="inner_cell">
									<h3 class="h_promt">컨시어지 서비스</h3>
									<p class="tit_promt">
										<span class="quote">워크샵 장소를<br>
추천해 드립니다!</span>
									</p>
									<span class="btn_opacity">바로가기</span>
								</div>
							</a>
						</li>
					
				</ul>
			</div>
		</div>
		<div class="nav_slide">
			<a href="javascript:void(0);" class="btn_slide_prev _banPrev">
				<i class="sp_icon ico_slide_prev">이전으로 이동</i>
			</a> <a href="javascript:void(0);" class="btn_slide_next _banNext">
				<i class="sp_icon ico_slide_next">다음으로 이동</i>
			</a>
		</div>
	</section>
	
	<section class="space_list_wrap _mainpage_item _mainpage_first" style="display: block;">
		<h2 class="main_sub_title">오늘의 추천 공간</h2>
		<div id="_spaceListScrollWrap" class="space_list swiper_list" data-sly-wrap-mobile="">
			<div class="flex_wrap column3 fluid" id="_spaceScroller">
				
				
					<article class="box box_space _space" data-sly-item="">
						<div class="inner">
							<a href="/space/803" _spaceid="803" class="_innerLink nclk" direction="spaceDetail" _nclk="con.recommend" _ncid="803" _nrank="1" param="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								
								
									<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180910_177/153658557682314h6I_JPEG/BFCB126E-BCF1-4D69-9408-981320876ED2.jpeg&quot;,&quot;https://scloud.pstatic.net/20181020_4/15400209934008fo0p_JPEG/%C8%AB%BA%B8%B9%AE-02.jpg&quot;,&quot;https://scloud.pstatic.net/20180910_106/1536585593111tecbT_JPEG/5641794E-EA53-41F4-8A3D-E23F99500945.jpeg&quot;,&quot;https://scloud.pstatic.net/20180910_85/1536585602234bWIq3_JPEG/387E0333-17CB-4BD0-BCAF-7DD7FC0A86A0.jpeg&quot;,&quot;https://scloud.pstatic.net/20180910_283/1536585609325i8J6C_JPEG/D3C94451-CC21-4CAA-A177-0E8823B9C531.jpeg&quot;,&quot;https://scloud.pstatic.net/20180817_26/153447779123304HpA_JPEG/02769C57-900B-4C29-A655-2A977A34700A.jpeg&quot;,&quot;https://scloud.pstatic.net/20180817_158/1534477811640FO3rx_JPEG/9312CA77-8769-450C-8582-50619A2D9E15.jpeg&quot;]" data-image-index="0">
										<span style="background-image: url(https://scloud.pstatic.net/20180910_177/153658557682314h6I_JPEG/BFCB126E-BCF1-4D69-9408-981320876ED2.jpeg?type=f369_208);" class="img lazy"></span>
										
										<div class="button_area">
											<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
											<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
										</div>
										
									</div>
								
								
								<span class="btns_reserv">
								
								<span href="javascript:void(0);" class="btn_reserv_confirm">승인<br>결제</span>
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">아지트 별하</h3>
									<div class="tags"><span class="tag_area_name">광주시 동구</span><span>#광주모임</span><span>#광주파티</span><span>#광주스터디</span><span>#광주</span><span>#파티룸</span></div>
									<div class="info_price_hour">
										<strong class="price">15,000~</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
												<i class="sp_icon ico_review">리뷰수</i><em>9</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>24</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
					<article class="box box_space _space" data-sly-item="">
						<div class="inner">
							<a href="/space/10280" _spaceid="10280" class="_innerLink nclk" direction="spaceDetail" _nclk="con.recommend" _ncid="10280" _nrank="2" param="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								
								
									<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20171117_116/1510902287966HfOS2_JPEG/IMG_6340.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_115/1510902338621UQmSc_JPEG/IMG_3267.jpg&quot;,&quot;https://scloud.pstatic.net/20171117_204/151090232010980bj4_JPEG/IMG_3316.jpg&quot;,&quot;https://scloud.pstatic.net/20171117_73/15109023309802wHTw_JPEG/IMG_2988.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_280/1510902324998ElC0Q_JPEG/IMG_2985.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_203/1510902374531yLVLx_JPEG/IMG_4071.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_167/1510902381530tcJG0_JPEG/IMG_3370.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_137/1510902396948A1gOm_JPEG/IMG_6548.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_107/1510902409805Dba84_JPEG/IMG_6335.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_250/15109024240338rX8w_JPEG/IMG_6607.JPG&quot;,&quot;https://scloud.pstatic.net/20171117_238/1510902427653v0b8P_JPEG/IMG_3359.JPG&quot;]" data-image-index="0">
										<span style="background-image: url(https://scloud.pstatic.net/20171117_116/1510902287966HfOS2_JPEG/IMG_6340.JPG?type=f369_208);" class="img lazy"></span>
										
										<div class="button_area">
											<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
											<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
										</div>
										
									</div>
								
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">부산파티룸[로케트살롱1-패키지]</h3>
									<div class="tags"><span class="tag_area_name">부산시 중구</span><span>#남포동파티룸</span><span>#부산파티룸</span><span>#부산연말모임</span><span>#부산브라이덜샤워파티</span><span>#부산프라이빗파티룸</span></div>
									<div class="info_price_hour">
										<strong class="price">40,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
												<i class="sp_icon ico_review">리뷰수</i><em>1</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>34</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
					<article class="box box_space _space" data-sly-item="">
						<div class="inner">
							<a href="/space/12007" _spaceid="12007" class="_innerLink nclk" direction="spaceDetail" _nclk="con.recommend" _ncid="12007" _nrank="3" param="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								
								
									<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180209_13/1518166243996SmCyJ_JPEG/03B91B8B-DB5A-4F31-868C-A6BB64A3D061.jpeg&quot;,&quot;https://scloud.pstatic.net/20180130_3/1517292516275taqyu_JPEG/03B91B8B-DB5A-4F31-868C-A6BB64A3D061.jpeg&quot;,&quot;https://scloud.pstatic.net/20180130_63/1517292527521WTHnW_JPEG/732D709E-2572-4ADC-AE94-7064D2B70EA3.jpeg&quot;,&quot;https://scloud.pstatic.net/20180130_151/151729253826929o2m_JPEG/AE93A6BF-79C7-4B2B-8814-7E7587E1F7B2.jpeg&quot;,&quot;https://scloud.pstatic.net/20180130_78/1517292552071fGtIK_JPEG/2B31AF93-C429-4F3C-B9E7-2A191BE810C9.jpeg&quot;,&quot;https://scloud.pstatic.net/20180130_187/1517292610512gO3Vj_JPEG/F8B330FD-8E2F-4464-8A57-E93511D33FEE.jpeg&quot;,&quot;https://scloud.pstatic.net/20180326_244/15220734552228AqOr_JPEG/DSC05913.jpg&quot;,&quot;https://scloud.pstatic.net/20180326_250/1522073459214bkIqD_JPEG/DSC07022.jpg&quot;,&quot;https://scloud.pstatic.net/20180326_99/1522073462357jQTwX_JPEG/DSC07027.jpg&quot;,&quot;https://scloud.pstatic.net/20180326_293/15220734719986w8ci_JPEG/DSC07055.jpg&quot;,&quot;https://scloud.pstatic.net/20180326_48/1522073476621djinI_JPEG/DSC07069.jpg&quot;]" data-image-index="0">
										<span style="background-image: url(https://scloud.pstatic.net/20180209_13/1518166243996SmCyJ_JPEG/03B91B8B-DB5A-4F31-868C-A6BB64A3D061.jpeg?type=f369_208);" class="img lazy"></span>
										
										<div class="button_area">
											<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
											<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
										</div>
										
									</div>
								
								
								<span class="btns_reserv">
								
								<span href="javascript:void(0);" class="btn_reserv_confirm">승인<br>결제</span>
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">조조하우스</h3>
									<div class="tags"><span class="tag_area_name">부산시 해운대구</span><span>#부산스몰웨딩</span><span>#한옥웨딩</span><span>#부산한옥</span><span>#브라이덜샤워</span><span>#부산파티룸</span></div>
									<div class="info_price_hour">
										<strong class="price">38,000~</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
												<i class="sp_icon ico_review">리뷰수</i><em>0</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>38</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
					<article class="box box_space _space" data-sly-item="">
						<div class="inner">
							<a href="/space/14054" _spaceid="14054" class="_innerLink nclk" direction="spaceDetail" _nclk="con.recommend" _ncid="14054" _nrank="4" param="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								
								
									<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180620_182/1529450867671BxBfA_JPEG/41B67FEE-81D6-436C-B7F3-CA9EE4D83B41.jpeg&quot;,&quot;https://scloud.pstatic.net/20180809_28/15338042384988tcLA_JPEG/612E104E-9E91-4B45-87C4-FE59D7378135.jpeg&quot;,&quot;https://scloud.pstatic.net/20180711_97/1531299962061N18XY_JPEG/16F0A353-09E1-44AE-8C2F-85A77518FF93.jpeg&quot;,&quot;https://scloud.pstatic.net/20180620_272/1529506134866npcMe_JPEG/20DF4136-DA22-44E5-8CB2-1D097D934333.jpeg&quot;,&quot;https://scloud.pstatic.net/20180628_158/1530111754628wqLuL_JPEG/7D7C9C5C-9476-49F3-BD40-CCA353C8F5C2.jpeg&quot;,&quot;https://scloud.pstatic.net/20180809_195/1533803985100fEkKi_JPEG/D18F3A90-0E88-4EF6-9682-2178555F4CE8.jpeg&quot;,&quot;https://scloud.pstatic.net/20180619_246/1529409963545Lh8YV_JPEG/BE21F602-BB6F-4371-8BAB-BA67C6EA573F.jpeg&quot;,&quot;https://scloud.pstatic.net/20180620_160/1529450880234IGqEt_JPEG/7189C56C-5741-42E5-93CB-7707C539BDD1.jpeg&quot;,&quot;https://scloud.pstatic.net/20180619_121/1529398949307RkFyp_JPEG/53C3A064-8C02-40A8-B11D-CBFC8FE67E9C.jpeg&quot;,&quot;https://scloud.pstatic.net/20180619_195/1529386959172KlKmP_JPEG/F1BE0B9B-DC42-4866-82B9-BB5E9A4244F9.jpeg&quot;,&quot;https://scloud.pstatic.net/20180619_257/1529399015842Rk978_JPEG/486605B9-16B7-474E-AB81-60816131AF8E.jpeg&quot;]" data-image-index="0">
										<span style="background-image: url(https://scloud.pstatic.net/20180620_182/1529450867671BxBfA_JPEG/41B67FEE-81D6-436C-B7F3-CA9EE4D83B41.jpeg?type=f369_208);" class="img lazy"></span>
										
										<div class="button_area">
											<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
											<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
										</div>
										
									</div>
								
								
								<span class="btns_reserv">
								
								<span href="javascript:void(0);" class="btn_reserv_confirm">승인<br>결제</span>
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">대구 파티룸 스튜디오반도</h3>
									<div class="tags"><span class="tag_area_name">대구시 달서구</span><span>#대구셀프스튜디오</span><span>#대구스튜디오</span><span>#대구장소대여</span><span>#대구파티룸</span><span>#대구공간대여</span></div>
									<div class="info_price_hour">
										<strong class="price">5,000</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
												<i class="sp_icon ico_review">리뷰수</i><em>7</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>61</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
					<article class="box box_space _space" data-sly-item="">
						<div class="inner">
							<a href="/space/15207" _spaceid="15207" class="_innerLink nclk" direction="spaceDetail" _nclk="con.recommend" _ncid="15207" _nrank="5" param="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								
								
									<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180921_144/153752536219305PyJ_JPEG/KakaoTalk_20180921_190645534.jpg&quot;,&quot;https://scloud.pstatic.net/20180921_267/153752536623726xWy_JPEG/KakaoTalk_20180921_190642963.jpg&quot;,&quot;https://scloud.pstatic.net/20180921_224/1537525368353iqooD_JPEG/KakaoTalk_20180921_190643719.jpg&quot;,&quot;https://scloud.pstatic.net/20180921_250/1537525370383aUF54_JPEG/KakaoTalk_20180921_190644310.jpg&quot;,&quot;https://scloud.pstatic.net/20180921_91/1537525375087XoS1e_JPEG/KakaoTalk_20180921_190646263.jpg&quot;,&quot;https://scloud.pstatic.net/20180921_28/1537525377598COVlj_JPEG/KakaoTalk_20180921_190644951.jpg&quot;]" data-image-index="0">
										<span style="background-image: url(https://scloud.pstatic.net/20180921_144/153752536219305PyJ_JPEG/KakaoTalk_20180921_190645534.jpg?type=f369_208);" class="img lazy"></span>
										
										<div class="button_area">
											<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
											<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
										</div>
										
									</div>
								
								
								<span class="btns_reserv">
								
								<span href="javascript:void(0);" class="btn_reserv_confirm">승인<br>결제</span>
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">지산낙원</h3>
									<div class="tags"><span class="tag_area_name">광주시 동구</span><span>#광주파티룸</span><span>#광주프로포즈</span><span>#광주브라이덜샤워</span><span>#지산낙원</span><span>#광주생일파티</span></div>
									<div class="info_price_hour">
										<strong class="price">50,000</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
												<i class="sp_icon ico_review">리뷰수</i><em>0</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>0</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
					<article class="box box_space _space" data-sly-item="">
						<div class="inner">
							<a href="/space/15230" _spaceid="15230" class="_innerLink nclk" direction="spaceDetail" _nclk="con.recommend" _ncid="15230" _nrank="6" param="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								
								
									<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180926_272/1537947903481ci3hN_JPEG/CF051FFE-46A6-4E94-9D28-ED93CFB1093A.jpeg&quot;,&quot;https://scloud.pstatic.net/20180926_188/1537947918640A8HrG_JPEG/6C4231C7-1B82-4076-974E-016BFF79F29E.jpeg&quot;,&quot;https://scloud.pstatic.net/20180926_292/1537947939783k54h5_JPEG/FC1FCF65-36B6-44DC-9DE1-054AE18B815E.jpeg&quot;,&quot;https://scloud.pstatic.net/20180926_203/1537947953252Gd07t_JPEG/AFB81615-25D2-4262-A676-4BE5AE4675ED.jpeg&quot;,&quot;https://scloud.pstatic.net/20180926_180/1537947964092wF7zs_JPEG/5B1AEF46-EE07-4E02-B916-0EA0D5050274.jpeg&quot;]" data-image-index="0">
										<span style="background-image: url(https://scloud.pstatic.net/20180926_272/1537947903481ci3hN_JPEG/CF051FFE-46A6-4E94-9D28-ED93CFB1093A.jpeg?type=f369_208);" class="img lazy"></span>
										
										<div class="button_area">
											<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
											<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
										</div>
										
									</div>
								
								
								<span class="btns_reserv">
								
								<span href="javascript:void(0);" class="btn_reserv_confirm">승인<br>결제</span>
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">hongchi-studio</h3>
									<div class="tags"><span class="tag_area_name">대구시 서구</span><span>#스튜디오</span><span>#파티룸</span><span>#작업실</span><span>#프라이빗룸</span></div>
									<div class="info_price_hour">
										<strong class="price">10,000</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
												<i class="sp_icon ico_review">리뷰수</i><em>0</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>4</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				<div id="spaceDetailVar" style="display:none;">
					<div id="spaceId"></div>
				</div>
			</div>
			<div class="swiper_pagination" data-sly-pagination="">
			</div>
		</div>
	</section>
	
	<section class="space_list_wrap bg_white _mainpage_item _mainpage_first" style="">
		<h2 class="main_sub_title">리뷰ZONE</h2>
		<p class="title_content">이용자들의 생생한 후기를 만나보세요</p>
			<!-- [D] div.masonry_list 높이값을 인라인으로 넣어주세요 -->
			<div class="masonry_list flex_wrap fluid list_center" id="_revwBnr_list" style="position: relative; height: 1742.97px;">
				<!--  <div id="_revwBnr_list" class="flex_wrap fluid list_center"> 
				<article class="box box_space box-sizer"></article> -->
				<!-- [D] 각 article.box에 인라인 타입으로 position 위치값을 넣어주세요 -->
				
				<!--  </div> -->
			<article class="box box_space _review_box" style="position: absolute; left: 10px; top: 0px;"><div class="inner"><a href="/space/7049" _spaceid="7049" class="_innerLink" direction="spaceDetail" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam">  <div class="slide_area" style="overflow: hidden;">  <ul class="slides" style="transform: translateZ(0px) translateX(0px); width: 1101px;">      <li class="slide active" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181024_194/1540342155960P0yt1_JPEG/KakaoTalk_20181021_223604064.jpg?type=f368_369);"></span>   </li>      <li class="slide" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181024_76/1540342162341gosXP_JPEG/KakaoTalk_20181021_223603183.jpg?type=f368_369);"></span>   </li>      <li class="slide" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181024_92/1540342148719o5t4k_JPEG/KakaoTalk_20181021_223637323.jpg?type=f368_369);"></span>   </li>     </ul>  <div class="slide_pagination"><span class="slide_pagination_bullet active">1</span><span class="slide_pagination_bullet">2</span><span class="slide_pagination_bullet">3</span></div> </div>  <div class="info_area type_border">  <div class="tags">      <span class="tag tag_primary">작업실</span>      <span class="tag tag_primary">파티룸</span>      <span class="tag tag_primary">서울시 영등포구</span>     </div>  <h3 class="tit_space">크레오스페이스 신길점</h3>  <div class="info_price_hour">   <strong class="price">25,000</strong><span class="txt_unit">원/시간</span>  </div>  <div class="review_area">   <span class="rate_area"><span class="blind">평점</span>    <span class="rate active"><em class="sp_icon ico_star_off">1점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">2점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">3점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">4점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">5점</em></span>   </span>   <p class="review_contents">원하는 시간 대여할수있어서 첫번째로 좋았구요
찾기 쉬워서 두번째로 좋았구요
주방이 깔끔하지 못했다고 하는 글들이 있었는데 그런걱정 안해도 되서 좋았구요
주변에 편의점도 가깝고 마트도 있구 냉장고와 수납장에 
남은 재료들과 조미료들이 있어서 좋았습니다
소중한 사람들과 좋은 시간 잘보냈습니다^^ </p>  </div> </div></a></div></article><article class="box box_space _review_box" style="position: absolute; left: 395px; top: 0px;"><div class="inner"><a href="/space/11434" _spaceid="11434" class="_innerLink" direction="spaceDetail" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam">  <div class="slide_area" style="overflow: hidden;">  <ul class="slides" style="transform: translateZ(0px) translateX(-367px); width: 1101px;">      <li class="slide" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181024_90/1540341122792GBX1z_JPEG/A351000B-9BBA-4112-BC97-38A4BEAEC70B.jpeg?type=f368_369);"></span>   </li>      <li class="slide active" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181024_29/1540341138247e8BFN_JPEG/94E6A24F-C55E-42CF-966F-813F8E2B09BD.jpeg?type=f368_369);"></span>   </li>      <li class="slide" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181024_20/1540341167640NJVAQ_JPEG/61B1A87D-CD83-427A-8977-43A54145EF2C.jpeg?type=f368_369);"></span>   </li>     </ul>  <div class="slide_pagination"><span class="slide_pagination_bullet">1</span><span class="slide_pagination_bullet active">2</span><span class="slide_pagination_bullet">3</span></div> </div>  <div class="info_area type_border">  <div class="tags">      <span class="tag tag_primary">파티룸</span>      <span class="tag tag_primary">작업실</span>      <span class="tag tag_primary">세미나실</span>      <span class="tag tag_primary">홍대합정</span>     </div>  <h3 class="tit_space">홍대파티룸 핑크코코[가을할인]</h3>  <div class="info_price_hour">   <strong class="price">50,000</strong><span class="txt_unit">원/일</span>  </div>  <div class="review_area">   <span class="rate_area"><span class="blind">평점</span>    <span class="rate active"><em class="sp_icon ico_star_off">1점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">2점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">3점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">4점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">5점</em></span>   </span>   <p class="review_contents">파티룸을 처음 이용해보았는데 정말 좋은 추억을 만들었습니다~
곧 결혼하는 친구를 위해 브라이덜샤워를 준비했는데  친구 4명끼리 이용하기에 공간도 생각보다 넓고 아늑했습니다~
위치도 상상마당 근처에 있어서 찾기도 시웠고 룸안에 다양한 게임기, 머리띠, 접시, 와인잔 등등이 있어서 정말 편리하게 이용했습니다~
적극 추천 100%만족 사장님 친절해요S2</p>  </div> </div></a></div></article><article class="box box_space _review_box no_image" style="position: absolute; left: 10px; top: 543px;"><div class="inner" style="background-image:url(https://scloud.pstatic.net/20181023_193/1540283848137meJSD_JPEG/KakaoTalk_20181023_170708426.jpg?type=f368_369)"><a href="/space/13384" _spaceid="13384" class="_innerLink" direction="spaceDetail" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam"> <div class="info_area type_border">  <div class="tags">      <span class="tag tag_primary">다목적홀</span>      <span class="tag tag_primary">연습실</span>      <span class="tag tag_primary">사당이수</span>     </div>  <h3 class="tit_space">댄스플 사당역 3분 연습실 별관</h3>  <div class="info_price_hour">   <strong class="price">4,500</strong><span class="txt_unit">원/시간</span>  </div>  <div class="review_area">   <span class="rate_area"><span class="blind">평점</span>    <span class="rate active"><em class="sp_icon ico_star_off">1점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">2점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">3점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">4점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">5점</em></span>   </span>   <p class="review_contents">연습실은 처음 이용해봤는데, 내부에 실내화가 있어서 좋았어요 
정수기도 비치되어있고, 거울도 왜곡없이 전면에 있어서 연습하기 좋았습니다. ㅎㅎ 사당역이랑 가까워서 찾기도 편하네요!!
다음에 또 이용할게요</p>  </div> </div></a></div></article><article class="box box_space _review_box" style="position: absolute; left: 395px; top: 543px;"><div class="inner"><a href="/space/14554" _spaceid="14554" class="_innerLink" direction="spaceDetail" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam">  <div class="photo_area"><div class="photo_inner">  <span class="photo"><img src="https://scloud.pstatic.net/20181023_180/1540287072873EcJlz_JPEG/1540043003513.jpg?type=f368_369" alt="리뷰사진"></span> </div></div>  <div class="info_area type_border">  <div class="tags">      <span class="tag tag_primary">파티룸</span>      <span class="tag tag_primary">다목적홀</span>      <span class="tag tag_primary">엠티장소</span>      <span class="tag tag_primary">서울시 용산구</span>     </div>  <h3 class="tit_space">하늘밑</h3>  <div class="info_price_hour">   <strong class="price">10,000</strong><span class="txt_unit">원/시간</span>  </div>  <div class="review_area">   <span class="rate_area"><span class="blind">평점</span>    <span class="rate active"><em class="sp_icon ico_star_off">1점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">2점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">3점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">4점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">5점</em></span>   </span>   <p class="review_contents">정말 말도안돼는 야경에 취해버렸습니다.
해질녘 올라가서 고기 구워 먹으며 오랜 만난 동기들과 좋은시간 보냈습니다. 세심한 배려와 구석구석 신경쓰신 꼼꼼함을 느낄 수 있었습니다!
다음에도 기회된다면 꼭! 재방문 의사 100만개!!</p>  </div> </div></a></div></article><article class="box box_space _review_box" style="position: absolute; left: 10px; top: 877px;"><div class="inner"><a href="/space/10608" _spaceid="10608" class="_innerLink" direction="spaceDetail" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam">  <div class="slide_area" style="overflow: hidden;">  <ul class="slides" style="transform: translateZ(0px) translateX(0px); width: 1101px;">      <li class="slide active" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181023_243/1540279822010USF6t_JPEG/DE99C038-EC92-430D-B5A4-4C0D4DBC69FB.jpeg?type=f368_369);"></span>   </li>      <li class="slide" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181023_31/1540279758157mRhQD_JPEG/61C977B3-F7ED-4FEA-BCE3-46A6E472C47C.jpeg?type=f368_369);"></span>   </li>      <li class="slide" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181023_207/1540279796786PuiFi_JPEG/6DACE53A-4C62-4541-B752-C61801DA1FE1.jpeg?type=f368_369);"></span>   </li>     </ul>  <div class="slide_pagination"><span class="slide_pagination_bullet active">1</span><span class="slide_pagination_bullet">2</span><span class="slide_pagination_bullet">3</span></div> </div>  <div class="info_area type_border">  <div class="tags">      <span class="tag tag_primary">엠티장소</span>      <span class="tag tag_primary">파티룸</span>      <span class="tag tag_primary">홍대합정</span>     </div>  <h3 class="tit_space">홍대파티룸 펜트하우스[10월할인]</h3>  <div class="info_price_hour">   <strong class="price">70,000</strong><span class="txt_unit">원/일</span>  </div>  <div class="review_area">   <span class="rate_area"><span class="blind">평점</span>    <span class="rate active"><em class="sp_icon ico_star_off">1점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">2점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">3점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">4점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">5점</em></span>   </span>   <p class="review_contents">6명이 사용했는데 공간도 넓고 너무 놓았어요 제가 예약했는데 덕분에 친구들이 너무 좋다며 칭찬해줬네요ㅋㅋㅋㅋㅋ정말 깨끗하고 할로윈 시즌이라 머리띠 같은것도 구비되어 있어서 사진도 많이 찍었어요 다음에 또 기회되면 이용하도록 하겠습니다!</p>  </div> </div></a></div></article><article class="box box_space _review_box" style="position: absolute; left: 395px; top: 1199px;"><div class="inner"><a href="/space/13548" _spaceid="13548" class="_innerLink" direction="spaceDetail" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam">  <div class="slide_area" style="overflow: hidden;">  <ul class="slides" style="transform: translateZ(0px) translateX(-367px); width: 734px;">      <li class="slide" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181023_259/1540252692620nwShs_JPEG/CFA22BF2-84FF-4A13-9F8B-E2325B111728.jpeg?type=f368_369);"></span>   </li>      <li class="slide active" style="width: 367px;">    <span class="slide_img" style="background-image:url(https://scloud.pstatic.net/20181023_195/1540252753715tWlf9_JPEG/2F752DCB-E2F7-4FA8-A868-F560C1B4635F.jpeg?type=f368_369);"></span>   </li>     </ul>  <div class="slide_pagination"><span class="slide_pagination_bullet">1</span><span class="slide_pagination_bullet active">2</span></div> </div>  <div class="info_area type_border">  <div class="tags">      <span class="tag tag_primary">세미나실</span>      <span class="tag tag_primary">엠티장소</span>      <span class="tag tag_primary">파티룸</span>      <span class="tag tag_primary">레저시설</span>      <span class="tag tag_primary">홍대합정</span>     </div>  <h3 class="tit_space">홍대 파티룸 홀라루프[10월할인]</h3>  <div class="info_price_hour">   <strong class="price">60,000</strong><span class="txt_unit">원/일</span>  </div>  <div class="review_area">   <span class="rate_area"><span class="blind">평점</span>    <span class="rate active"><em class="sp_icon ico_star_off">1점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">2점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">3점</em></span>    <span class="rate active"><em class="sp_icon ico_star_off">4점</em></span>    <span class="rate "><em class="sp_icon ico_star_off">5점</em></span>   </span>   <p class="review_contents">친구들과 브라이덜 샤워 하려고 예약이용 했습니다. 생각보다 크지 않은 룸이었지만 넷이서 먹고 놀기에 적당하고 풍선으로 꾸미기에도 수월했습니다. 저희가 이용한 날은 날씨가 너무 좋아서 테라스에서 놀기에도 아주 좋았습니다. 해가 잘 들어와 사진 찍고 놀기에 안성맞춤인 공간이었습니다. 다음에 기념일이 생기면 또 이용할게요^ㅡ^</p>  </div> </div></a></div></article></div>
			<a href="javascript:void(0);" class="btn_more_review type_white _mainpage_contents_more" role="button">
				<span class="txt_more_review">더보기</span>
			</a>
	</section>
	
	<section class="space_list_wrap _mainpage_item _mainpage_second" style="display:none;">
		<h2 class="main_sub_title">써 본 사람</h2>
		<p class="title_content">매력적인 공간을 도시작가가 경험하고 소개합니다</p>
		<div class="written_list">
			<a href="http://www.indieworkers.net/urbanwriterseason1" target="_blank" class="link_text link_apply">
				<span>작가지원하기</span>
				<i class="sp_icon ico_link_circle">작가지원하기 링크</i>
			</a>
			<div id="_wrtr_list" class="flex_wrap fluid list_center"></div>
		</div>
		<a href="javascript:void(0);" class="btn_more_review type_white _mainpage_contents_more" role="button">
			<span class="txt_more_review">더보기</span>
		</a>
	</section>
	
	<section class="theme_list_wrap _mainpage_item _mainpage_third" style="display:none;">
		<h2 class="main_sub_title">기획전</h2>
		<p class="title_content">스클 MD가 큐레이션한 기획전 입니다</p>
		<div class="theme_list">
			<div id="_theme_list" class="flex_wrap column3 fluid list_center"></div>
			<div id="pickVar" style="display:none;">
				<div id="pick">pick</div>
				<div id="picSeq"></div>
			</div>
		</div>
		<a href="javascript:void(0);" class="btn_more_review type_white _mainpage_contents_more" role="button">
			<span class="txt_more_review">더보기</span>
		</a>
	</section>
	
	</div>
</div>

<footer class="footer">
    <div class="inner_width">
        <div class="inner_wrap">
            <div class="top_area">
                <a href="/" class="footer_logo nclk" _nclk="fot.logo"><span class="sp_icon logo_footer">spaceCloud</span></a>
                <ul class="bar_list link_info">
                    <li><a href="http://blog.naver.com/spacecloud" target="_blank" class="nclk" _nclk="fot.blog">블로그</a></li>
                    <li><a href="/agreement" class="nclk" _nclk="fot.agreement">이용약관</a></li>
                    <li><a href="/policyPerson" class="nclk" _nclk="fot.privacy">개인정보처리방침</a></li>
                    <li><a href="/policyOperate" class="nclk" _nclk="fot.policy">운영정책</a></li>
                    <li><a href="https://talk.naver.com/ct/wc89we" target="_blank" title="새창열림" class="nclk" _nclk="fot.adtalk">고객 문의</a></li>
                </ul>
                <a href="javascript:void(0);" class="btn_toggle">
                    <span class="btn_inner">(주)NSPACE 사업자정보 및 통신판매업자 신원정보</span>
                </a>
            </div>
            <div class="bottom_area">
                <ul class="bar_list company_info">
                    <li class="first">상호명: 주식회사 앤스페이스</li>
                    <li>대표: 정수현</li>
                    <li>사업자등록번호: 230-81-03117</li>
                    <li>통신판매업신고번호: 2018-서울중구-0772</li>
                    <li class="business_info"><a href="http://www.ftc.go.kr/www/bizCommView.do?key=232&amp;apv_perm_no=2018301013030200778&amp;pageUnit=10&amp;searchCnd=wrkr_no&amp;searchKrwd=2308103117&amp;pageIndex=1" target="_blank" title="새창열림">사업자등록정보</a></li>
                    <li>영업소재지: 서울특별시 중구 명동11길 20, 서울YWCA회관빌딩 6층 601호</li>
	 				<li class="email_info">이메일: <a href="mailto:office@spacecloud.kr">office@spacecloud.kr</a></li>
	 				<li class="call_info">대표전화: 1599-4312(평일 오후 2시 ~ 오후 6시)</li>
	 				<li><a href="https://talk.naver.com/ct/wc89we" class="link" target="_blank" title="새창열림">온라인 1:1 문의 바로가기</a>(평일 오전 10시 ~ 오후 6시)</li>
                    <li class="first">* 공간에 대한 문의사항은 해당 공간 호스트에게 직접 문의해주세요.</li>
                </ul>
                <p class="p_caution">스페이스클라우드는 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 스페이스클라우드는 공간 거래정보 및 거래에 대해 책임지지 않습니다.</p>
            </div>
            <div class="policy_area">
                <div class="sns_list">
                    <a href="http://blog.naver.com/spacecloud" class="sp_icon ico_blog" title="새창열림" target="_blank">블로그</a>
                    <a href="http://post.naver.com/spacecloud" class="sp_icon ico_post" title="새창열림" target="_blank">포스트</a>
                    <a href="https://www.facebook.com/spaceclouding" class="sp_icon ico_facebook" title="새창열림" target="_blank">페이스북</a>
                    <a href="https://twitter.com/spacecloud_kr" class="sp_icon ico_tweeter" title="새창열림" target="_blank">트위터</a>
                    <a href="https://www.pholar.co/my/762749/profile" class="sp_icon ico_polar" title="새창열림" target="_blank">폴라</a>
                    <a href="https://www.instagram.com/spacecloud.kr" class="sp_icon ico_instagram" title="새창열림" target="_blank">인스타그램</a>
                </div>
                <ul class="bar_list">
                    <li><a href="/agreement">이용약관</a></li>
                    <li><a href="/policyPerson">개인정보처리방침</a></li>
                    <li><a href="/policyOperate">운영정책</a></li>
                </ul>
            </div>
            <p class="copyright">
                <a href="http://www.nspace.co/" target="_blank" class="copy_mobile nclk" _nclk="fot.nspace" title="새창열림">ⓒNSPACE Corp.</a>
                <span class="copy_pc">Copyright <a href="http://www.nspace.co/" target="_blank" title="새창열림" class="nclk" _nclk="fot.nspace">NSPACE Corp.</a> All Rights Reserved.</span>
            </p>
        </div>
    </div>
</footer>
<script type="text/javascript">
	var imgUrl = "https://ssl.pstatic.net/spacecloud/static/web/20180813/";
	var pinfra = "https://scloud.pstatic.net";
	var _iniFunc = function() {
		var _id = 'home';
		if (spacecloud.jpage) {
			if (spacecloud.jpage._pages[_id]
					&& !spacecloud.jpage._pages[_id].mainobject) {
				spacecloud.home.jsonPageData = {};
				spacecloud.jpage.appendOO(spacecloud.home, _id);
			}
		}
		$(document).off("jPageReady", _iniFunc);
		$(document).off("_pushStateChanged", _iniFunc);
		$(document).off("_popStateChanged", _iniFunc);
		$(document).off("customMainInit", _iniFunc);
	};
	$(document).on("jPageReady", _iniFunc);
	$(document).on("_pushStateChanged", _iniFunc);
	$(document).on("_popStateChanged", _iniFunc);
	$(document).on("customMainInit", _iniFunc);
</script>
 </div>
			<div id="search" _path="/search" _position="1" _fit="false" _firstposition="[0, 0]" _reload="true" class="_page" style="width: 768px; overflow: hidden; height: 911px; visibility: hidden;">
			





<div id="content_wraper" role="main">
	<div class="header header_map" style="display:none;">
		<h1 class="p_keyword _ttl"></h1>
		<a href="javascript:void(0);" class="nav_delete _mapClose">
			<i class="sp_icon ico_delete">검색닫기</i>
		</a>
	</div>
	<div class="map mapWrap" style="display: none; position: absolute; background: rgb(235, 235, 235); overflow: hidden; height: 911px;">
		<div class="inner _map" id="_searchMap">
		</div>
		<div class="fixed_area _clusterList" style="display:block;">
			<div class="fixed_list" style="overflow:hidden;">
				<ul class="map_sp_list _clusterData"></ul>
			</div>
		</div>
		<div class="nav_wrap">
			<a href="javascript:void(0);" class="btn_nav btn_prev _move _prev">
				<i class="ico_prev sp_icon">이전목록으로</i>
			</a>
			<a href="javascript:void(0);" class="btn_nav btn_next _move _next">
				<i class="ico_next sp_icon">다음목록으로</i>
			</a>
		</div>
	</div>
	<section class="notice_area keyword" data-search-option-wrap="">
		<div class="inner_width">
		
		
		
					
					
			<h2 class="blind">검색조건</h2>
			<div class="center_wrap">
				<div class="center">
					<h3 class="blind">키워드</h3>
					<div class="result_wrap">
						<!-- [D] txt_keyword 클릭 시 상단 바의 검색창 활성화해주세요. -->
						<a href="javascript:void(0);" class="txt_keyword _search_query" title="검색창 열림">10월 할인</a>(으)로
						<span class="txt_result"> 검색한 결과입니다.</span>
						<h3 class="keyword _dym"></h3>
						<input type="hidden" data-search-param="q" value="10월 할인">
						
					</div>
				</div>
			</div>
			
			<div class="search_wrap">
				<div class="box_search">
					<!-- [D] 모바일에서 셀렉트 박스에서 선택 후,
					검색화면으로 돌아왔을 때 클래스 active 추가해주세요-->
					<div class="flex_wrap">
						<dl class="flex_box">
							<dt class="flex tit">공간유형</dt>
							<dd class="flex">
								<!-- [D] 셀렉트 박스 클릭 시, on 클래스 추가해주세요 -->
								<div class="select">
									<a href="#">
										<span>모든 공간</span>
									</a>
								</div>
								<div class="select_box" style="display: none;">
									<div class="select_title">
										<strong>공간유형</strong>
									</div>
									<div class="select_layer">
										<ul class="check_list">
											
												<li data-searchbox-value="회의실" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space1"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space1" class="ellip">회의실</label>
							                    </li>
											
												<li data-searchbox-value="세미나실" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space2"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space2" class="ellip">세미나실</label>
							                    </li>
											
												<li data-searchbox-value="다목적홀" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space3"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space3" class="ellip">다목적홀</label>
							                    </li>
											
												<li data-searchbox-value="작업실" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space4"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space4" class="ellip">작업실</label>
							                    </li>
											
												<li data-searchbox-value="레저시설" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space5"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space5" class="ellip">레저시설</label>
							                    </li>
											
												<li data-searchbox-value="파티룸" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space6"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space6" class="ellip">파티룸</label>
							                    </li>
											
												<li data-searchbox-value="공연장" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space7"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space7" class="ellip">공연장</label>
							                    </li>
											
												<li data-searchbox-value="연습실" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space8"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space8" class="ellip">연습실</label>
							                    </li>
											
												<li data-searchbox-value="카페" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space9"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space9" class="ellip">카페</label>
							                    </li>
											
												<li data-searchbox-value="스터디룸" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space10"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space10" class="ellip">스터디룸</label>
							                    </li>
											
												<li data-searchbox-value="엠티장소" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space11"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space11" class="ellip">엠티장소</label>
							                    </li>
											
												<li data-searchbox-value="독립 오피스" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space12"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space12" class="ellip">독립 오피스</label>
							                    </li>
											
												<li data-searchbox-value="코워킹 스페이스" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space13"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space13" class="ellip">코워킹 스페이스</label>
							                    </li>
											
												<li data-searchbox-value="일하기 좋은 카페" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space14"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space14" class="ellip">일하기 좋은 카페</label>
							                    </li>
											
												<li data-searchbox-value="공동 작업실" data-searchbox-type="CATEGORY">
							                        <input type="radio" name="space" id="space15"><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							                        <label for="space15" class="ellip">공동 작업실</label>
							                    </li>
											
						                </ul>
									</div>
									<a href="#" class="btn_pop_close" title="레이어팝업 닫힘">
										<i class="sp_icon ico_pop_close">레이어팝업닫기</i>
									</a>
								</div>
							</dd>
						</dl>
						<dl class="flex_box">
							<dt class="flex tit">지역</dt>
							<dd class="flex">
								<!-- [D] 셀렉트 박스 클릭 시, on 클래스 추가해주세요 -->
								<div class="select">
									<a href="#">
										<span>모든 지역</span>
									</a>
								</div>
								<div class="select_box" style="display: none;">
									<div class="select_title">
										<strong>지역</strong>
									</div>
									<div class="select_layer">
										<ul class="check_list type_tab2">
						                    <li>
						                        <input type="radio" name="tab" id="region" checked=""><!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
						                        <label for="region">지역</label>
						                    </li>
						                    <li>
						                        <input type="radio" name="tab" id="subway">
						                        <label for="subway">지하철</label>
						                    </li>
										</ul>
										<div class="search">
							        		<!-- [D] 지역 tab 활성화 시, region_active 클래스 추가 / 지하철 tab 활성화 시, subway_active 클래스 추가해주세요  -->
											<div class="input region_active">
									        	<input type="text" id="region_name" class="region_text ui-autocomplete-input" title="지역명 입력" placeholder="지역을 입력해주세요." required="" autocomplete="off">
												<input type="text" id="subway_name" class="subway_text ui-autocomplete-input" title="지하철명 입력" placeholder="수도권 지하철역을 입력해주세요." required="" autocomplete="off">	
							        			
												<a href="#" class="btn_search">
													<i class="sp_icon ico_search_place">검색</i>
												</a>
							        		</div>
											<!-- 단어 자동완성 레이어 -->
											<div class="auto_word_layer" style="display: none;">
												<div class="word_wrap">
													<ul class="words">
														<!-- [D] 노선별 아이콘, 클래스 추가 -->
														<!--서울 1호선 ~ 9호선: subway_capital_line1~9
															인천 1호선 ~ 2호선: subway_capital_line21,22
															분당선, 신분당선, 경춘선, 경의중앙선, 경강선, 공항철도,
															자기부상, 에버라인, 수인선, 우이신설선, 의정부선 : subway_capital_line100~110
															부산 1호선 ~ 4호선 : subway_busan_line1~4
															동해선, 부산-김해경전철: subway_busan_line100,101
															대구 1호선 ~ 3호선: subway_daegu_line1~3
															광주 1호선: subway_gwangju_line1
															대전 1호선: subway_daejeon_line1 -->
														<li class="word">
														</li>
													</ul>
												</div>
											</div>
											<!-- //단어 자동완성 레이어 -->
										</div>
									</div>
									<a href="#" class="btn_pop_close" title="레이어팝업 닫힘">
										<i class="sp_icon ico_pop_close">레이어팝업닫기</i>
									</a>
								</div>
							</dd>
						</dl>
						<dl class="flex_box">
							<dt class="flex tit">이용일</dt>
							<dd class="flex">
								<!-- [D] 셀렉트 박스 클릭 시, on 클래스 추가해주세요 -->
								<div class="select select_calendar">
									<a href="#" class="select_date">
										
									       
									           <span>모든 날짜</span>
									       
									       
									   
									</a>
								</div>
								<div class="select_box" style="display: none;">
									<div class="select_title">
										<strong>이용일</strong>
									</div>
									<div class="calendar_layer">
									    <div class="calendar_wrap">
									        <div class="calendar_tit">
									            <a href="#" class="btn_month_prev"><span class="sp_icon">이전</span></a>
									            <strong><em>2018</em>.<em>10</em></strong>
									            <a href="#" class="btn_month_next"><span class="sp_icon">다음</span></a>
									        </div>
									        <div class="calendar_checkbox">
									            <input type="checkbox" name="date" value="" id="date_all">
									            <label for="date_all">모든 날짜</label>
									        </div>
									        <div id="datepicker" class="calendar hasDatepicker">
									            
									        <div class="ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all" style="display: block;"><div class="ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all"><a class="ui-datepicker-prev ui-corner-all ui-state-disabled" title="Prev"><span class="ui-icon ui-icon-circle-triangle-w">Prev</span></a><a class="ui-datepicker-next ui-corner-all" data-handler="next" data-event="click" title="Next"><span class="ui-icon ui-icon-circle-triangle-e">Next</span></a><div class="ui-datepicker-title"><span class="ui-datepicker-year">2018</span>&nbsp;<span class="ui-datepicker-month">10</span></div></div><table class="ui-datepicker-calendar"><thead><tr><th scope="col" class="ui-datepicker-week-end"><span title="Sunday">일</span></th><th scope="col"><span title="Monday">월</span></th><th scope="col"><span title="Tuesday">화</span></th><th scope="col"><span title="Wednesday">수</span></th><th scope="col"><span title="Thursday">목</span></th><th scope="col"><span title="Friday">금</span></th><th scope="col" class="ui-datepicker-week-end"><span title="Saturday">토</span></th></tr></thead><tbody><tr><td class="ui-datepicker-week-end ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled  disable" style="visibility: hidden;"><a class="ui-state-default" href="#">30</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">1</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">2</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">3</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">4</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">5</a></td><td class="ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">6</a></td></tr><tr><td class="ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">7</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">8</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">9</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">10</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">11</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">12</a></td><td class="ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">13</a></td></tr><tr><td class="ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">14</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">15</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">16</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">17</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">18</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">19</a></td><td class="ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">20</a></td></tr><tr><td class="ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">21</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">22</a></td><td class="ui-datepicker-unselectable ui-state-disabled  disable"><a class="ui-state-default" href="#">23</a></td><td class="ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today today" data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default ui-state-highlight ui-state-active ui-state-hover" href="#">24</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default" href="#">25</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default" href="#">26</a></td><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default" href="#">27</a></td></tr><tr><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default" href="#">28</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default" href="#">29</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default" href="#">30</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="9" data-year="2018"><a class="ui-state-default" href="#">31</a></td><td class="ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled  disable" style="visibility: hidden;"><a class="ui-state-default" href="#">1</a></td><td class="ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled  disable" style="visibility: hidden;"><a class="ui-state-default" href="#">2</a></td><td class="ui-datepicker-week-end ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled  disable" style="visibility: hidden;"><a class="ui-state-default" href="#">3</a></td></tr></tbody></table></div></div>
									        <div class="calendar_note">
									            <ul class="note_list">
									                <li class="note_item">
									                    <i class="select_icon today">노란색</i>
									                    <span>오늘</span>
									                </li>
									                <li class="note_item">
									                    <i class="select_icon datepick">보라색</i>
									                    <span>선택</span>
									                </li>
									            </ul>
									        </div>
									    </div>
									</div>

									<a href="#" class="btn_pop_close" title="레이어팝업 닫힘">
										<i class="sp_icon ico_pop_close">레이어팝업닫기</i>
									</a>
								</div>
							</dd>
						</dl>
					</div>
				</div>
				<div class="btn_area">
					<a href="javascript:void(0);" class="btn_location type_color _showMap" role="button">
						<span class="txt_location">지도</span>
					</a>
					<!-- [D] 필터 링크 클릭 시,
						1. aria-expanded 속성 값을 true로 바꿔주세요.
						2. 하단의 .layer_select.type_filter 레이어가 나타나게 해주세요.
						3. (width 1258px 미만) 스크롤을 상단으로 이동해주시고, wrap 높잇값을 레이어 높이만큼 설정해주세요. -->
					<!-- [D] 선택된 필터가 있을 경우, selected 클래스를 추가해주세요. -->
					<a href="#" class="btn_filter type_color _flink _filter_option" role="button" aria-haspopup="true" aria-expanded="false" data-style-filter-count="">
						<span class="count">9+<span class="blind">개 선택됨</span></span>
						<span class="txt_filter">필터</span>
					</a>
				</div>
			</div>
		</div>
	</section>
	<section class="filter_area ">
		<div class="layer_select type_filter" id="select8" style="display: none;">
			<div class="layer_header">
				<div class="header header_select">
					<a href="javascript:void(0)" class="logo">
						<i class="sp_icon ico_main_logo">SpaceCloud</i>
					</a>
					<a href="#" class="nav_delete" data-close-btn="">
						<i class="sp_icon ico_delete">필터 닫기</i>
					</a>
				</div>
				<div class="header_text">
					<strong>필터</strong>를 적용하세요.
				</div>
			</div>
			<div class="layer_body">
			
			
			
				
				
				<div class="category_row">
					<!-- [D] 결제유형 -->
					<div class="category_wrap">
						<div class="category_title">
							<strong>결제유형</strong>을 선택하세요.
							<span class="option_check">
								<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
								<input type="checkbox" name="payment_all" id="no_care3" class="checkbox" data-sync-checked="[name=payment]">
								<label for="no_care3">전체 유형</label>
							</span>
						</div>
						<ul class="check_list">
							<!-- [D] 선택된 단위에 checked 클래스 추가 -->
							<li>
								<input type="radio" name="payment" id="payment1" value="NOWPY" data-sync-checked="[name=payment_all]" data-parent-checked="">
								<label for="payment1">바로결제</label>
							</li>
							<li>
								<input type="radio" name="payment" id="payment2" value="FIXPY" data-sync-checked="[name=payment_all]" data-parent-checked="">
								<label for="payment2">승인결제</label>
							</li>
						</ul>
					</div>
					<!-- [D] 가격범위 -->
					<div class="category_wrap">
						<div class="category_title">
							<strong>가격범위</strong>를 선택하세요.
							<span class="option_check">
								<input type="checkbox" name="price_all" id="no_care5" class="checkbox" data-sync-disabled="[name=price_min], [name=price_max], [data-price-wrap]">
								<label for="no_care5">전체 범위</label>
							</span>
						</div>
						<!-- [D] 전체 범위 체크시, disabled 클래스를 추가해주세요. (input에도 disbled 속성 추가)-->
						<div class="input_wrap disabled" data-price-wrap="">
							<div class="input guide price">
								<input type="tel" name="price_min" class="number_set _number" value="0" maxlength="8" disabled="">
							</div>
							<div class="input guide price">
								<input type="tel" name="price_max" class="number_set _number" value="0" maxlength="8" disabled="">
							</div>
						</div>
					</div>
				</div>
				<!-- [D] 편의시설-->
				<div class="category_wrap">
					<div class="category_title">
						<strong class="category">편의시설</strong>을 선택하세요.
						<span class="option_check">
							<input type="checkbox" name="facility_all" id="no_care6" class="checkbox" data-sync-checked="[name=facility]">
							<label for="no_care6">전체 선택</label>
						</span>
					</div>
					<ul class="check_list space">
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility1" value="TVBM" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility1">TV/프로젝터</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility2" value="WIFI" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility2">인터넷/WIFI</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility3" value="CPY" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility3">복사/인쇄기</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility4" value="WBD" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility4">화이트보드</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility5" value="AMP" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility5">음향/마이크</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility6" value="COOK" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility6">취사시설</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility7" value="FOOD" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility7">음식물반입가능</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility8" value="ACL" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility8">주류반입가능</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility9" value="SWR" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility9">샤워시설</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility10" value="PARK" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility10">주차</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility11" value="NSMK" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility11">금연</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility12" value="FET" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility12">반려동물 동반가능</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility13" value="PCLAP" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility13">PC/노트북</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility14" value="CHTBL" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility14">의자/테이블</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility15" value="EPLUG" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility15">콘센트</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility16" value="H24" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility16">24시 운영</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility17" value="NOBRK" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility17">연중무휴</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility18" value="CAFE" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility18">카페/레스토랑</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility19" value="SNACK" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility19">간단한 다과/음료</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility20" value="STASH" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility20">개인락커</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility21" value="MAIL" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility21">메일 서비스</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility22" value="PBPTY" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility22">공용 주방</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility23" value="PRFR" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility23">정수기</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility24" value="CATR" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility24">케이터링</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility25" value="HEATR" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility25">난방기</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility26" value="AIRCN" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility26">에어컨</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility27" value="FAX" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility27">팩스</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility28" value="BIZRG" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility28">주소지 서비스</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility29" value="WRHUS" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility29">창고서비스</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility30" value="DLVRY" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility30">택배발송서비스</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility31" value="INTLT" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility31">내부화장실</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility32" value="FITRM" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility32">탈의실</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility33" value="RFTOP" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility33">테라스/루프탑</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility34" value="PBLUG" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility34">공용라운지</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility35" value="FLMIR" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility35">전신거울</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility36" value="BABEQ" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility36">바베큐시설</label>
						</li>
						
						<li>
							<!-- [D] label, input id 맞춰주세요 (웹접근성 관련)-->
							<input type="checkbox" name="facility" id="facility37" value="DRLOK" data-sync-checked="[name=facility_all]" data-parent-checked="">
								<label for="facility37">도어락</label>
						</li>
						
					</ul>
				</div>
			</div>
			<div class="layer_footer">
				<div class="btn_area">
					<div class="btn_wrap">
						<a href="#" class="btn btn_negative" role="button" data-reset-btn="">초기화</a>
					</div>
					<div class="btn_wrap">
						<a href="#" class="btn btn_default" role="button" data-submit-btn="">필터 적용하기 <span class="count" data-filter-count="">0</span>
						</a>
					</div>
				</div>
			</div>
				<input type="hidden" data-search-param="rsvMthCd" value="">
				<input type="hidden" data-search-param="minPrc" value="">
				<input type="hidden" data-search-param="maxPrc" value="">
				<input type="hidden" data-search-param="cnvenFctsCds" value="">
				<input type="hidden" data-search-param="useYmd" value="">
		</div>
		<div class="inner_width">
			<ul class="unit_filter" data-select-for="#selected_unit_type">
				<!-- [D] 단위 선택 시, aria-selected 속성 값을 true로 변경해주세요. -->
				<li class="unit_item" aria-selected="true">
					<a href="#" class="unit_link" data-value="">전체</a>
				</li>
				<li class="unit_item" aria-selected="false">
					<a href="#" class="unit_link" data-value="TIME">시간단위</a>
				</li>
				<li class="unit_item" aria-selected="false">
					<a href="#" class="unit_link" data-value="DAY">일단위</a>
				</li>
				<li class="unit_item" aria-selected="false">
					<a href="#" class="unit_link" data-value="MONTH">월단위</a>
				</li>
			</ul>
			<input type="hidden" id="selected_unit_type" data-search-param="rsvTpCd" value="">
			<!-- [D] label 클릭 시 sorting_filter에 on클래스를 추가해주세요. (아이콘)-->
			<div class="sorting_filter">
				<!-- [D] 선택된 option의 텍스트를 label에 넣어주세요 -->
				<label for="sorting">베스트 공간 순</label>
				<select name="" id="sorting" data-search-param="order">
					<option value="BEST_DESC" selected="">베스트 공간 순</option>
					<option value="PRC_ASC">가격 낮은 순</option>
					<option value="PRC_DESC">가격 높은 순</option>
					<option value="CMNT_DESC">이용후기 많은 순</option>
					
					
				</select>
			</div>
		</div>
	</section>
	<section class="result_area" data-hide-for-filter="">
		
		
		
		<div id="spaceDetailVar" style="display:none;">
			<div id="spaceId"></div>
		</div>
		




	<div class="inner_width">
		<h2 class="blind">검색결과</h2>
		




		
		<div class="space_list swiper-container">
			<div class="flex_wrap column3 fluid _articles">
		
			
				
					
					
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/10608" _spaceid="10608" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20171129_47/1511916736550vCR0Q_JPEG/1.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_147/1511916514189euPzI_JPEG/1.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_130/1511916672400w3YUh_JPEG/2.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_84/15119166853178wLWY_JPEG/3.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_133/15119167096783zHLz_JPEG/5.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_46/1511916720476B4CX4_JPEG/6.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_5/1511916739204zu3gE_JPEG/7.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_220/15119167417466Sy2z_JPEG/8.JPG&quot;,&quot;https://scloud.pstatic.net/20171129_206/1511916770265Hbdpa_JPEG/9.JPG&quot;,&quot;https://scloud.pstatic.net/20181016_109/1539677836747Ta93v_JPEG/%C6%E6%C6%AE_%C7%D2%B7%CE1.jpg&quot;,&quot;https://scloud.pstatic.net/20181016_167/1539677841119HGQmY_JPEG/%C6%E6%C6%AE_%C7%D2%B7%CE2.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20171129_47/1511916736550vCR0Q_JPEG/1.JPG?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">홍대파티룸 펜트하우스[10월할인]</h3>
									<div class="tags"><span class="tag_area_name">홍대합정</span><span>#홍대파티룸</span><span>#파티룸</span><span>#올나잇</span><span>#엠티</span><span>#모임공간</span></div>
									<div class="info_price_hour">
										<strong class="price">70,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>117</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>1267</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/3557" _spaceid="3557" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20170113_164/1484290401857W9VgI_JPEG/20170102_122357_-_%BA%B9%BB%E7%BA%BB.jpg&quot;,&quot;https://scloud.pstatic.net/20170113_126/1484290394137KOfwG_JPEG/20170102_122425_-_%BA%B9%BB%E7%BA%BB.jpg&quot;,&quot;https://scloud.pstatic.net/20170113_175/1484290408057mL7f2_JPEG/20170102_122357_-_%BA%B9%BB%E7%BA%BB.jpg&quot;,&quot;https://scloud.pstatic.net/20181019_250/15399189609428hAjP_JPEG/20181019_120641.jpg&quot;,&quot;https://scloud.pstatic.net/20170220_154/1487586139689qpHmR_JPEG/20161202_010121.jpg&quot;,&quot;https://scloud.pstatic.net/20181019_276/15399189975564nyoR_JPEG/20181018_184617.jpg&quot;,&quot;https://scloud.pstatic.net/20181019_299/1539919006559uKYyi_JPEG/20181018_184440.jpg&quot;,&quot;https://scloud.pstatic.net/20170220_210/1487586307393XuGYJ_JPEG/20170113_140743.jpg&quot;,&quot;https://scloud.pstatic.net/20170220_243/1487586325867jcQ6w_JPEG/20170102_122959_-_%BA%B9%BB%E7%BA%BB.jpg&quot;,&quot;https://scloud.pstatic.net/20170220_236/1487586335732zycAl_JPEG/20170102_123056.jpg&quot;,&quot;https://scloud.pstatic.net/20181019_138/1539919103784qy94B_JPEG/20181017_150938.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20170113_164/1484290401857W9VgI_JPEG/20170102_122357_-_%BA%B9%BB%E7%BA%BB.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">홍대 파티룸 그라운드[10월할인]</h3>
									<div class="tags"><span class="tag_area_name">홍대합정</span><span>#홍대파티룸</span><span>#홍대</span><span>#파티룸</span><span>#합정파티룸</span><span>#엠티</span></div>
									<div class="info_price_hour">
										<strong class="price">35,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>164</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>2604</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/2861" _spaceid="2861" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180821_56/1534828743430c64SY_JPEG/%BB%FD%C0%CF%C6%C4%C6%BC_%B0%F8%B0%A3%B4%EB%BF%A9_%B0%AD%B3%B2%C6%C4%C6%BC%B7%EB4.JPG&quot;,&quot;https://scloud.pstatic.net/20181022_221/154018801805191A6r_PNG/569C4288-DA9B-4293-96CE-DDC4A41ED189.png&quot;,&quot;https://scloud.pstatic.net/20181012_267/1539278797436jQMvf_JPEG/EB5EFD57-69F3-4001-9A54-C3636B59A33B.jpeg&quot;,&quot;https://scloud.pstatic.net/20180821_255/1534828846346cThr2_JPEG/Maiblume_-3.jpg&quot;,&quot;https://scloud.pstatic.net/20181015_1/1539612741267WXrgb_JPEG/B5C32ED1-80B3-45A8-AA29-72C8E27F8504.jpeg&quot;,&quot;https://scloud.pstatic.net/20181012_155/1539278375094ebBYV_JPEG/CA3CCEFD-D6A8-40F2-9652-E6626355EE39.jpeg&quot;,&quot;https://scloud.pstatic.net/20181015_24/1539573810196Bodmz_PNG/FE61A9CC-1477-4F81-B686-D03205A19989.png&quot;,&quot;https://scloud.pstatic.net/20180831_20/1535678702048axruN_JPEG/514D0392-4EBC-4CD5-B9EB-C91BCD94194E.jpeg&quot;,&quot;https://scloud.pstatic.net/20181015_297/1539612507879h03lB_JPEG/180CD01D-4F4A-433F-9D05-2912D86A03F0.jpeg&quot;,&quot;https://scloud.pstatic.net/20181015_134/15395737483822rpc5_JPEG/FB7212B4-3492-4091-9038-C5DBA0AE67FE.jpeg&quot;,&quot;https://scloud.pstatic.net/20180831_226/1535678743508m7VYo_JPEG/2BCACFCF-E79E-4D04-B7F0-3A659EC889AF.jpeg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20180821_56/1534828743430c64SY_JPEG/%BB%FD%C0%CF%C6%C4%C6%BC_%B0%F8%B0%A3%B4%EB%BF%A9_%B0%AD%B3%B2%C6%C4%C6%BC%B7%EB4.JPG?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								
								<span href="javascript:void(0);" class="btn_reserv_confirm">승인<br>결제</span>
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">[10월할인]강남파티룸 마이블루메</h3>
									<div class="tags"><span class="tag_area_name">강남</span><span>#올나잇</span><span>#생일파티</span><span>#송년회</span><span>#브라이덜샤워</span><span>#워크샵</span></div>
									<div class="info_price_hour">
										<strong class="price">44,000</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>6</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>333</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/14723" _spaceid="14723" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180930_186/1538312752400i3Bbv_JPEG/KakaoTalk_20180930_215707851.jpg&quot;,&quot;https://scloud.pstatic.net/20180902_23/1535875173427YnYL8_JPEG/KakaoTalk_20180902_163342504.jpg&quot;,&quot;https://scloud.pstatic.net/20181010_15/1539176333774Y3RJt_JPEG/2018-10-10-21-56-00.jpg&quot;,&quot;https://scloud.pstatic.net/20180902_236/15358753961648xzpK_JPEG/2018-09-01-19-13-30.jpg&quot;,&quot;https://scloud.pstatic.net/20180902_73/1535875441745mOPVR_JPEG/2018-09-01-19-13-36.jpg&quot;,&quot;https://scloud.pstatic.net/20181010_33/1539176013689LnYJH_JPEG/1539161262209.jpg&quot;,&quot;https://scloud.pstatic.net/20181010_213/1539176369154PiVki_JPEG/1539051976718.jpg&quot;,&quot;https://scloud.pstatic.net/20181010_263/1539177673947qHFqy_JPEG/2018-10-06-20-00-40.jpg&quot;,&quot;https://scloud.pstatic.net/20181010_119/1539177734308uMz4Y_JPEG/2018-10-02-18-51-26.jpg&quot;,&quot;https://scloud.pstatic.net/20181010_253/1539176111733INgdb_JPEG/1539088775240.jpg&quot;,&quot;https://scloud.pstatic.net/20181010_187/1539177101000FUHJd_JPEG/2018-10-09-19-39-49.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20180930_186/1538312752400i3Bbv_JPEG/KakaoTalk_20180930_215707851.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">홍대 그녀들의시크릿 10월 할인</h3>
									<div class="tags"><span class="tag_area_name">홍대합정</span><span>#홍대파티룸</span><span>#브라이덜샤워</span><span>#홍대루프탑파티룸</span><span>#홍대생일파티</span><span>#홍대모임</span></div>
									<div class="info_price_hour">
										<strong class="price">50,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>30</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>142</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/13548" _spaceid="13548" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20181023_82/15402874984697H4fn_JPEG/2.jpg&quot;,&quot;https://scloud.pstatic.net/20180514_129/1526307673388DNjNc_JPEG/2-1.jpg&quot;,&quot;https://scloud.pstatic.net/20180514_176/1526307675351l2NGF_JPEG/2-2.jpg&quot;,&quot;https://scloud.pstatic.net/20180514_265/15263076838728naaV_JPEG/3.jpg&quot;,&quot;https://scloud.pstatic.net/20180514_114/1526307686401CEHFW_JPEG/4.jpg&quot;,&quot;https://scloud.pstatic.net/20180514_210/1526307687874FNgxI_JPEG/5.jpg&quot;,&quot;https://scloud.pstatic.net/20181023_248/1540287528584mb9y7_JPEG/2.jpg&quot;,&quot;https://scloud.pstatic.net/20181023_108/1540287535226kcKNE_JPEG/3.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20181023_82/15402874984697H4fn_JPEG/2.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">홍대 파티룸 홀라루프[10월할인]</h3>
									<div class="tags"><span class="tag_area_name">홍대합정</span><span>#홍대파티룸</span><span>#파티룸</span><span>#브라이덜샤워</span><span>#루프탑파티룸</span><span>#루프탑</span></div>
									<div class="info_price_hour">
										<strong class="price">60,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>35</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>280</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/8259" _spaceid="8259" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180205_62/1517759272937QqBfn_JPEG/1517651621020.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_278/1517651754583ebfJn_JPEG/1517651617084.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_210/1517651811214p7gu7_JPEG/1517651621020.jpg&quot;,&quot;https://scloud.pstatic.net/20170902_281/1504333438203IyVn1_JPEG/1504333426266.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_249/1517651733938Ej2B8_JPEG/1517651097972.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_91/1517651773551FsFyO_JPEG/1517651613861.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_110/1517651787077gTwzz_JPEG/1517651614650.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_166/1517651792953C6os9_JPEG/1517651616202.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_100/1517651802625kR3mP_JPEG/20180203_160627.jpg&quot;,&quot;https://scloud.pstatic.net/20180203_74/1517651825469UtCOC_JPEG/20180203_160503.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20180205_62/1517759272937QqBfn_JPEG/1517651621020.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">[10월할인]파티룸무지개홍대2점</h3>
									<div class="tags"><span class="tag_area_name">홍대합정</span><span>#우정커플파티</span><span>#생일파티</span><span>#기념일</span><span>#홍대합정신촌파티룸</span></div>
									<div class="info_price_hour">
										<strong class="price">50,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>10</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>538</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/11001" _spaceid="11001" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20171211_64/1512982056543bQF74_JPEG/20171205_181251.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_124/15129820970527pqKX_JPEG/20171205_181301.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_269/1512982121429Fwal6_JPEG/20171205_180909.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_171/1512982149974Aztci_JPEG/20171207_131730.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_207/1512982200178XVGjH_JPEG/20171205_181340.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_32/1512982241653zrbnR_JPEG/20171205_181258.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_123/1512982317718coERm_JPEG/IMG_20171211_174605_015.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_292/1512982322641e16KN_JPEG/IMG_20171211_174607_751.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_113/1512982328723EM4BD_JPEG/IMG_20171211_174553_118.jpg&quot;,&quot;https://scloud.pstatic.net/20171211_6/15129823450068RBBj_JPEG/IMG_20171211_174559_597.jpg&quot;,&quot;https://scloud.pstatic.net/20181005_112/1538718574360YGqfa_JPEG/20181005_141808.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20171211_64/1512982056543bQF74_JPEG/20171205_181251.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">우주놀일터 [10월 할인 이벤트]</h3>
									<div class="tags"><span class="tag_area_name">송파가락시장</span><span>#세미나</span><span>#촬영장소</span><span>#파티룸</span><span>#일일클래스</span><span>#생일파티</span></div>
									<div class="info_price_hour">
										<strong class="price">20,000</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>0</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>79</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/12942" _spaceid="12942" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180401_202/1522583531210MWTXX_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%283%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180522_227/1526993624515dt6UG_JPEG/%C8%AB%B4%EB_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%B5%CE%B5%D2%C4%A9_%281%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_57/1522583537581j8WaK_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%286%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_224/1522583540053y4Vz9_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%283%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_75/1522583568564PttkS_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%2811%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180522_139/1526993650489aDWDW_JPEG/%C8%AB%B4%EB_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%B5%CE%B5%D2%C4%A9_%282%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_223/1522583576983w6IjG_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%2810%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_197/1522583583517oDjVl_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%2819%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_66/15225835466795tbl9_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%288%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_199/1522583591940GaO69_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%2821%29.jpg&quot;,&quot;https://scloud.pstatic.net/20180401_15/1522583586477jppu6_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%2820%29.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20180401_202/1522583531210MWTXX_JPEG/%B5%CE%B5%D2%C4%A9_%C7%C3%B6%F3%B9%D6%B0%ED_%C6%C4%C6%BC%B7%EB_%C8%AB%B4%EB_%BC%AD%BF%EF_%283%29.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">홍대파티룸 플라밍고[10월 할인]</h3>
									<div class="tags"><span class="tag_area_name">홍대합정</span><span>#모임공간</span><span>#올나잇</span><span>#생일파티</span><span>#엠티</span><span>#홍대파티룸</span></div>
									<div class="info_price_hour">
										<strong class="price">90,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>9</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>281</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/10405" _spaceid="10405" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20171208_246/1512663367178KEpBX_JPEG/A9C01087-49C2-4262-A62A-A33DFF160C30.jpeg&quot;,&quot;https://scloud.pstatic.net/20180116_231/1516094864461HQ2B2_JPEG/118DAC81-7B92-486C-97AA-D5E6065662AE.jpeg&quot;,&quot;https://scloud.pstatic.net/20180116_187/151609507514005jFY_JPEG/EDE88DEC-1DDB-40A8-BCD7-003ABB8DF0A6.jpeg&quot;,&quot;https://scloud.pstatic.net/20180331_124/1522466800546uIbRE_JPEG/E1372E9F-AA84-44C8-BE72-E32C5A5C72C4.jpeg&quot;,&quot;https://scloud.pstatic.net/20171208_28/1512663437912nWyWC_JPEG/B5A21895-7E38-4F45-BADA-360AAC55D221.jpeg&quot;,&quot;https://scloud.pstatic.net/20180331_158/1522466834099P7lCi_JPEG/4223CE9E-49C2-417A-AC3E-EA72C3D4D0FF.jpeg&quot;,&quot;https://scloud.pstatic.net/20171205_170/1512438649451703qC_JPEG/0B0F3DA1-D7F1-44D7-BB90-FEE78F024F54.jpeg&quot;,&quot;https://scloud.pstatic.net/20180116_18/1516095187499TzpUJ_JPEG/8E814017-ED97-4182-85B1-703B3492591A.jpeg&quot;,&quot;https://scloud.pstatic.net/20180116_38/15160951518953KQrH_JPEG/B03002D6-02D9-496D-AE0C-EA7A0797650C.jpeg&quot;,&quot;https://scloud.pstatic.net/20180331_114/1522466988597JhAlG_JPEG/408A4B3B-03D0-47EB-A62E-2D9C1B9D8BE2.jpeg&quot;,&quot;https://scloud.pstatic.net/20171205_3/1512438693271arIkt_JPEG/61BEA518-2D3D-4445-B99F-5C622250D564.jpeg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20171208_246/1512663367178KEpBX_JPEG/A9C01087-49C2-4262-A62A-A33DFF160C30.jpeg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">강남파티룸]투데이즈파티-10월할인</h3>
									<div class="tags"><span class="tag_area_name">강남</span><span>#10명파티룸</span><span>#30명파티룸</span><span>#20명파티룸</span><span>#40명파티룸</span><span>#대규모파티룸</span></div>
									<div class="info_price_hour">
										<strong class="price">15,000~</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>0</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>124</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/15071" _spaceid="15071" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180930_96/1538274696145I7GDO_JPEG/%BD%BA%C6%E4%C0%CC%BD%BA_%C5%AC%B6%F3%BF%EC%B5%E5_%B8%DE%C0%CE%BB%E7%C1%F8.jpg&quot;,&quot;https://scloud.pstatic.net/20180930_211/1538274004788tnGH9_JPEG/KakaoTalk_20180930_111846663.jpg&quot;,&quot;https://scloud.pstatic.net/20180930_250/15382747040610u9hA_JPEG/%BD%BA%C6%E4%C0%CC%BD%BA_%C5%AC%B6%F3%BF%EC%B5%E5_%B8%DE%C0%CE%BB%E7%C1%F8.jpg&quot;,&quot;https://scloud.pstatic.net/20180930_240/15382748414917QjdO_JPEG/3%B9%F8%C2%B0_%BB%E7%C1%F8.jpg&quot;,&quot;https://scloud.pstatic.net/20180930_118/1538274853546vNEoR_JPEG/2%B9%F8%C2%B0_%BB%E7%C1%F8.jpg&quot;,&quot;https://scloud.pstatic.net/20180926_227/1537953220990kLEov_JPEG/16E0F2B0-893B-491E-98C9-673EA1C83887.jpeg&quot;,&quot;https://scloud.pstatic.net/20180910_144/1536579745007eynuH_JPEG/KakaoTalk_20180910_203506316.jpg&quot;,&quot;https://scloud.pstatic.net/20180926_120/1537953238498ApXum_JPEG/67CA8FC8-CD32-43EA-8FDC-1147D8F0DE95.jpeg&quot;,&quot;https://scloud.pstatic.net/20180913_256/1536830055094kXWQd_JPEG/E588AC55-CA4D-49B4-943B-2CBF503131B2.jpeg&quot;,&quot;https://scloud.pstatic.net/20180913_119/1536830085672lMu2s_JPEG/98B37862-12D7-46AA-8193-392E3B2FB899.jpeg&quot;,&quot;https://scloud.pstatic.net/20180930_87/1538269494455Pv01b_JPEG/KakaoTalk_20180930_095338341.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20180930_96/1538274696145I7GDO_JPEG/%BD%BA%C6%E4%C0%CC%BD%BA_%C5%AC%B6%F3%BF%EC%B5%E5_%B8%DE%C0%CE%BB%E7%C1%F8.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								
								<span href="javascript:void(0);" class="btn_reserv_confirm">승인<br>결제</span>
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">파티룸 레트로하우스 [10월할인]</h3>
									<div class="tags"><span class="tag_area_name">이태원한남</span><span>#이태원파티룸</span><span>#파티룸</span><span>#이태원</span></div>
									<div class="info_price_hour">
										<strong class="price">60,000~</strong><span class="txt_unit">원/일</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>0</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>11</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/5939" _spaceid="5939" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20170726_136/1501059991550ERfew_JPEG/IMG_20170716_201307_604.jpg&quot;,&quot;https://scloud.pstatic.net/20170828_260/1503908406458WvQN8_JPEG/1503200962047.jpg&quot;,&quot;https://scloud.pstatic.net/20170726_97/1501060049382uUWqD_JPEG/IMG_20170718_174200_400.jpg&quot;,&quot;https://scloud.pstatic.net/20170514_242/1494764926722vm45E_JPEG/1494764796254.jpg&quot;,&quot;https://scloud.pstatic.net/20170725_207/1500966018538reqq3_JPEG/pic20170725155710.jpg&quot;,&quot;https://scloud.pstatic.net/20170617_32/1497630887811uDCpx_JPEG/1497617322126.jpg&quot;,&quot;https://scloud.pstatic.net/20170630_36/1498787992554JwRVK_JPEG/1498739151197.jpg&quot;,&quot;https://scloud.pstatic.net/20170717_145/1500277656514mezaj_JPEG/1496746331294.jpg&quot;,&quot;https://scloud.pstatic.net/20170717_55/1500277598415tP2px_JPEG/1496747932065.jpg&quot;,&quot;https://scloud.pstatic.net/20170617_102/1497630904812NaDkg_JPEG/1497617151243.jpg&quot;,&quot;https://scloud.pstatic.net/20170726_212/15010600706881Tz7E_JPEG/1497665796740.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20170726_136/1501059991550ERfew_JPEG/IMG_20170716_201307_604.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">[10월할인]파티룸무지개홍대점</h3>
									<div class="tags"><span class="tag_area_name">홍대합정</span><span>#친구우정커플파티</span><span>#생일파티</span><span>#루프탑옥상파티</span><span>#홍대합정신촌파티룸</span><span>#이벤트기념일</span></div>
									<div class="info_price_hour">
										<strong class="price">50,000~</strong><span class="txt_unit">원/시간</span>
										
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>15</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>130</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
				
					<article class="box box_space">
						<div class="inner">
							<a href="/space/14896" _spaceid="14896" class="_innerLink" direction="spaceDetail" params="" pathparam="spaceDetailVar" executefnc="setSpaceDetailParam" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); -webkit-tap-highlight-color: transparent;">
								<div class="img_box" data-image-urls="[&quot;https://scloud.pstatic.net/20180901_247/15357939028790e2pV_JPEG/%BD%BA%C5%AC.jpg&quot;,&quot;https://scloud.pstatic.net/20180901_70/1535793914140bmFra_JPEG/%BD%BA%C5%AC.jpg&quot;,&quot;https://scloud.pstatic.net/20180830_228/1535639210621i3svu_JPEG/001.jpg&quot;,&quot;https://scloud.pstatic.net/20180830_27/1535639213464cktUN_JPEG/002.jpg&quot;,&quot;https://scloud.pstatic.net/20180830_206/1535639216025WV8Mr_JPEG/003.jpg&quot;,&quot;https://scloud.pstatic.net/20180906_203/1536218841907rPXnW_JPEG/KakaoTalk_20180906_162251344.jpg&quot;,&quot;https://scloud.pstatic.net/20180830_136/1535639219172lceGC_JPEG/004.jpg&quot;,&quot;https://scloud.pstatic.net/20180830_74/1535639231215qocoK_JPEG/006.jpg&quot;,&quot;https://scloud.pstatic.net/20180906_236/1536221932522oHCpO_JPEG/4567.jpg&quot;,&quot;https://scloud.pstatic.net/20180906_114/1536221936980xLChN_JPEG/45678.jpg&quot;]" data-image-index="0">
									<span style="background-image: url(https://scloud.pstatic.net/20180901_247/15357939028790e2pV_JPEG/%BD%BA%C5%AC.jpg?type=f369_208);" class="img"></span>
									<div class="button_area ">
										<button type="button" class="button_img button_img_prev"><i class="sp_icon ico_img_prev">이전 이미지 보기</i></button>
										<button type="button" class="button_img button_img_next"><i class="sp_icon ico_img_next">다음 이미지 보기</i></button>
									</div>
								</div>
								
								<span class="btns_reserv">
								<span href="javascript:void(0);" class="btn_reserv_now">바로<br>결제</span>
								
								
								</span>
								
								
								
								<div class="info_area">
									<h3 class="tit_space">신림 로제이연습실 [2호점]</h3>
									<div class="tags"><span class="tag_area_name">신림서울대입구</span><span>#신림연습실</span><span>#댄스연습실</span><span>#사당연습실</span><span>#연기연습실</span><span>#보컬연습실</span></div>
									<div class="info_price_hour">
										<strong class="price">4,000~</strong><span class="txt_unit">원/시간</span>
										<i class="sp_icon ico_npay">네이버페이 사용가능</i>
									</div>
									<div class="info_number_love">
										<span class="txt_number_review">
											<i class="sp_icon ico_review">리뷰수</i><em>35</em>
										</span>
										<span class="txt_number_love">
											<i class="sp_icon ico_love">좋아요</i> <em>151</em>
										</span>
									</div>
								</div>
							</a>
						</div>
					</article>
				
		
				<div id="spaceDetailVar" style="display:none;">
					<div id="spaceId"></div>
				</div>
			</div>
		</div>
		


		<span class="loading" style="display:none;"> <i class="ico_loading sp_icon"></i></span>
	</div>

<script type="text/javascript">
var nomorsearch = false;
var pagingParam = {"originalQuery":"10월 할인","refinedQuery":"할인 ","seperatedQueries":["10월","할인"],"typedQuerys":[{"name":"할인","type":"TERM"}],"attendyMin":"","ttlMatched":"[10월할인]강남파티룸 마이블루메","localities":{"strategicalCortarInfo":[],"cityCortarInfo":[],"dvsnCortarInfo":[],"secCortarInfo":[]},"cateogories":[],"terms":["할인"],"titleTerms":["10월","할인"],"fromMainSearch":false,"isSubwaySearch":false,"pageCount":12,"totalCount":524,"page":1,"skipCount":0};


var dym = eval();
if(dym && dym!=undefined) {
	var link="javascript:void(0);", cls = "";
	if(dym&& dym.length &&dym.length==1){
		var q = encodeURI("10월 할인".replace(dym[0][0].trim().replace(/[시,군,구,읍,면,동]/ig, ""), dym[0][1]));
		link="/search?q="+q;
	}else{
		if(dym && dym.length&& dym.length>1) {
			cls = "_addDup";
		}
	}
	$("._dym").html('<p class="txt_confirm">찾으시는 공간이 지역명 &ldquo;<a href="'+link+'" class="'+cls+'">'+dym[0][0]+'</a>&rdquo;인가요?</p>');
}

var _sparam = {
	q: "10월 할인",
	page : 1,
	tcnt : 524,
	
	rsvMthCd : "",
	rsvTpCd : "",
	minPrc : "",
	maxPrc : "",
	cnvenFctsCds : "",
	order : "BEST_DESC",
	
	lat :37.54882400,
	lng : 126.92245000
	
	
};




$("._showMap").show();


</script>
	</section>
</div>


<footer class="footer">
    <div class="inner_width">
        <div class="inner_wrap">
            <div class="top_area">
                <a href="/" class="footer_logo nclk" _nclk="fot.logo"><span class="sp_icon logo_footer">spaceCloud</span></a>
                <ul class="bar_list link_info">
                    <li><a href="http://blog.naver.com/spacecloud" target="_blank" class="nclk" _nclk="fot.blog">블로그</a></li>
                    <li><a href="/agreement" class="nclk" _nclk="fot.agreement">이용약관</a></li>
                    <li><a href="/policyPerson" class="nclk" _nclk="fot.privacy">개인정보처리방침</a></li>
                    <li><a href="/policyOperate" class="nclk" _nclk="fot.policy">운영정책</a></li>
                    <li><a href="https://talk.naver.com/ct/wc89we" target="_blank" title="새창열림" class="nclk" _nclk="fot.adtalk">고객 문의</a></li>
                </ul>
                <a href="javascript:void(0);" class="btn_toggle">
                    <span class="btn_inner">(주)NSPACE 사업자정보 및 통신판매업자 신원정보</span>
                </a>
            </div>
            <div class="bottom_area">
                <ul class="bar_list company_info">
                    <li class="first">상호명: 주식회사 앤스페이스</li>
                    <li>대표: 정수현</li>
                    <li>사업자등록번호: 230-81-03117</li>
                    <li>통신판매업신고번호: 2018-서울중구-0772</li>
                    <li class="business_info"><a href="http://www.ftc.go.kr/www/bizCommView.do?key=232&amp;apv_perm_no=2018301013030200778&amp;pageUnit=10&amp;searchCnd=wrkr_no&amp;searchKrwd=2308103117&amp;pageIndex=1" target="_blank" title="새창열림">사업자등록정보</a></li>
                    <li>영업소재지: 서울특별시 중구 명동11길 20, 서울YWCA회관빌딩 6층 601호</li>
	 				<li class="email_info">이메일: <a href="mailto:office@spacecloud.kr">office@spacecloud.kr</a></li>
	 				<li class="call_info">대표전화: 1599-4312(평일 오후 2시 ~ 오후 6시)</li>
	 				<li><a href="https://talk.naver.com/ct/wc89we" class="link" target="_blank" title="새창열림">온라인 1:1 문의 바로가기</a>(평일 오전 10시 ~ 오후 6시)</li>
                    <li class="first">* 공간에 대한 문의사항은 해당 공간 호스트에게 직접 문의해주세요.</li>
                </ul>
                <p class="p_caution">스페이스클라우드는 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 스페이스클라우드는 공간 거래정보 및 거래에 대해 책임지지 않습니다.</p>
            </div>
            <div class="policy_area">
                <div class="sns_list">
                    <a href="http://blog.naver.com/spacecloud" class="sp_icon ico_blog" title="새창열림" target="_blank">블로그</a>
                    <a href="http://post.naver.com/spacecloud" class="sp_icon ico_post" title="새창열림" target="_blank">포스트</a>
                    <a href="https://www.facebook.com/spaceclouding" class="sp_icon ico_facebook" title="새창열림" target="_blank">페이스북</a>
                    <a href="https://twitter.com/spacecloud_kr" class="sp_icon ico_tweeter" title="새창열림" target="_blank">트위터</a>
                    <a href="https://www.pholar.co/my/762749/profile" class="sp_icon ico_polar" title="새창열림" target="_blank">폴라</a>
                    <a href="https://www.instagram.com/spacecloud.kr" class="sp_icon ico_instagram" title="새창열림" target="_blank">인스타그램</a>
                </div>
                <ul class="bar_list">
                    <li><a href="/agreement">이용약관</a></li>
                    <li><a href="/policyPerson">개인정보처리방침</a></li>
                    <li><a href="/policyOperate">운영정책</a></li>
                </ul>
            </div>
            <p class="copyright">
                <a href="http://www.nspace.co/" target="_blank" class="copy_mobile nclk" _nclk="fot.nspace" title="새창열림">ⓒNSPACE Corp.</a>
                <span class="copy_pc">Copyright <a href="http://www.nspace.co/" target="_blank" title="새창열림" class="nclk" _nclk="fot.nspace">NSPACE Corp.</a> All Rights Reserved.</span>
            </p>
        </div>
    </div>
</footer>
<script type="text/javascript">
var searchParam = {"subwaySearch":false,"originalQuery":"10월 할인","refinedQuery":"할인 ","seperatedQueries":["10월","할인"],"attendyMin":"","cateogories":[],"localities":{"cortarListsforLog":"","cityCortarInfo":[],"dvsnCortarInfo":[],"strategicalCortarInfo":[],"secCortarInfo":[]},"terms":["할인"],"totalCount":524,"pageCount":12,"skipCount":0,"fromMainSearch":false,"typedQuerys":[{"name":"할인","type":"TERM"}],"ttlMatched":"[10월할인]강남파티룸 마이블루메","titleTerms":["10월","할인"],"page":1};
var imgUrl = "https://ssl.pstatic.net/spacecloud/static/web/20180813/"; 
var pinfra = "https://scloud.pstatic.net";
var isPick = false;
var _iniFunc = function() { 
	var _id = 'search';
	if(spacecloud.jpage) {
		if(spacecloud.jpage._pages[_id]) {
			spacecloud.search.jsonPageData = {};
			spacecloud.jpage.appendOO(spacecloud.search,_id);
		}
	}
	$(document).off("jPageReady", _iniFunc); 
	$(document).off("_pushStateChanged", _iniFunc); 
	$(document).off("_popStateChanged", _iniFunc); 
	$(document).off("customMainInit", _iniFunc); 
}; 
$(document).on("jPageReady", _iniFunc); 
$(document).on("_pushStateChanged", _iniFunc); 
$(document).on("_popStateChanged", _iniFunc); 
$(document).on("customMainInit", _iniFunc); 
</script>

			</div>
			<div id="spaceDetail" _path="/space" _position="2" _fit="false" _firstposition="[0, 0]" _reload="true" class="_page" style="width: 768px; height: 911px; overflow: hidden;"></div>
		</div>
	</div>

<div class="btn_order_area detail_contact_footer _enableEl" style="display:none;">
	<a href="javascript:void(0);" class="btn btn_default _connect_talk nclk" _spaceid="" _nclk="res.talk">
		<span class="txt_talk"><i class="sp_icon ico_talk"></i>톡톡하기</span>
	</a>
	<a href="javascript:void(0);" class="btn btn_default _gotoReservation">예약신청하기</a>
</div>
<a href="javascript:void(0);" class="btn_fixed_top">
	<span class="sp_icon ico_top">페이지 상단으로 이동</span>
</a>
<div class="dimmed" style="display: none; height: 4342px;"></div>
</div>


<script src="https://ssl.pstatic.net/spacecloud/static/web/js/deploy/20181023113009/min/jqueryScrollPlugins.min.js" type="text/javascript"></script>
<script src="https://ssl.pstatic.net/spacecloud/static/web/js/deploy/20181023113009/min/flow.min.js" type="text/javascript"></script>
<script src="https://ssl.pstatic.net/spacecloud/static/web/js/deploy/20181023113009/min/search.min.js" type="text/javascript"></script>
<script type="text/javascript">
var today = "20181024";
</script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/maps3.js?_v20181024"></script>
<script src="https://ssl.pstatic.net/spacecloud/static/web/js/deploy/20181023113009/min/map.min.js" type="text/javascript"></script><span id="_jpageSearchQuery" class="_innerLink" direction="search" style="position:fixed;width:0;height:0" paramsattr="data-search-param"></span><div class="layer_popup keyword" style="top:90px;display:none;z-index:9999;">	<div class="popup_wrap">		<div class="pop_container">			<p class="pop_guide_txt">				검색어 중, 다른 <strong>“중복지역명”</strong>이 있습니다.<br>				조건에 맞는 검색어를 선택하세요.			</p>			<div class="list_radio _data">				<ul></ul>			</div>			<div class="btns">				<a class="btn btn_full btn_negative _close" href="javascript:void(0);">취소</a>				<a class="btn btn_full btn_default _submit" href="javascript:void(0);">확인</a>			</div>		</div>	</div></div><div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div><ul class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content" id="ui-id-1" tabindex="0" style="display: none;"></ul><span role="status" aria-live="assertive" aria-relevant="additions" class="ui-helper-hidden-accessible"></span><ul class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content" id="ui-id-2" tabindex="0" style="display: none;"></ul><span role="status" aria-live="assertive" aria-relevant="additions" class="ui-helper-hidden-accessible"></span>
</body>
</html>
