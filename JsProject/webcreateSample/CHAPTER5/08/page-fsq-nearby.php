<?php
/*
Template Name: Foursquare Nearby
*/
?>

<?php

// Foursquare Developer API 情報
$base_url = 'http://estab.net';
$client_id = 'ABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFG';
$client_secret = 'ABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFGABCDEFG';

try{

	//問い合わせURLの構築
	$search_venues_url = "https://api.foursquare.com/v2/venues/search";
	$search_venues_url .= "?client_id=" . $client_id;
	$search_venues_url .= "&client_secret=" .$client_secret;
	$search_venues_url .= "&ll=35.6630059245,139.745042324";
	$search_venues_url .= "&limit=10";
	
	//JSON形式でvenue情報を取得
	$response = json_decode(file_get_contents($search_venues_url), true);

	$items = $response['response']['groups'][0]['items'];

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
				<?php get_template_part('content'); ?>
				<?php 
					//周辺のvenueの施設名とcheckin数をリスト表示					
					print "<table>";
					print "<tr>";
					print "<th>";
					print "施設名";
					print "</th>";
					print "<th>";
					print "checkin数";
					print "</th>";
					print "</tr>";
					foreach ($items as $venue) {
						print "<tr>";
						print "<td>";
						print_r($venue['name']);
						print "</td>";
						print "<td>";
						print_r($venue['stats']['checkinsCount']);						
						print "</td>";
						print "</tr>";
					}
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