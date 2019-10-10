<?php
/*
Template Name: Foursquare Venue Detail
*/
?>

<?php

// Foursquare Developer API 情報
$client_id = 'ABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFG';
$client_secret = 'ABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFG';

try{

	//venueIDを設定
	$venue_id = '4b3159b4f964a520400525e3';
	$today = '20121216';

	//問い合わせURLの構築
	$search_venues_url = "https://api.foursquare.com/v2/venues/" .$venue_id;
	$search_venues_url .= "?client_id=" .$client_id;
	$search_venues_url .= "&client_secret=" .$client_secret;

	//JSON形式でvenue情報を取得
	$response = json_decode(file_get_contents($search_venues_url), true);

	$venue = $response['response']['venue'];

}catch(Exception $e){
	echo $e->getMessage();
}
?>

<?php get_header(); ?>
        	<div id="post-content" class="clearfix">
				<?php if (have_posts()) : while (have_posts()) : the_post(); ?>

            	<!-- パンくずリスト -->	
		    	<div id="breadcrumbs">
				<?php
					if(function_exists('bcn_display')){
						bcn_display();
					}
				?>
				</div>

				<div class="page-entry clearfix">

        		<h1 class="page-title"><?php the_title(); ?></h1>			
				<?php 
				
					//foursquare APIのレスポンス情報から様々な情報を表示
			
					print "<table>";
					print "<tr>";
					print "<td>施設名</td>";
					print "<td>".$venue['name']."</td>";
					print "</tr>";
					
					$location =$venue['location']['state'] .$venue['location']['city'] .$venue['location']['address'] .$venue['location']['crossStreet'];
					print "<tr>";
					print "<td>施設情報</td>";
					print "<td>".$location."</td>";
					print "</tr>";
					
					print "<tr>";
					print "<td>施設カテゴリー</td>";
					print "<td>".$venue['categories'][0]['pluralName']."</td>";
					print "</tr>";
					
					print "<tr>";
					print "<td colspan='2'>";
					//緯度を取得
					$lat = $venue['location']['lat'];
					//経度を取得
					$lng = $venue['location']['lng'];
					//Google Maps APIを利用し、緯度と経度から地図情報を表示
					print "<img src='http://maps.google.com/maps/api/staticmap?center=" .$lat ."," .$lng ."&amp;markers=" .$lat ."," .$lng ."&amp;zoom=15&amp;path=color:0x0000FF80|weight:5&amp;size=530x300&amp;sensor=true'>";
					print "</td>";
					print "</tr>";
					print "</table>";

				?>
				
			</div>
		        <!-- END page-entry -->

			<?php endwhile; ?>
			<?php endif; ?>	
            </div>
            <!-- END post-content -->
<?php get_sidebar(); ?>     
<?php get_footer(); ?>