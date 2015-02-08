<?php  
if(isset($_GET['uno'])){
$url = $_GET['uno'];
$url_content = '';  
$file = @fopen($url, 'r');  
if($file){  
  while(!feof($file)) {  
    $url_content .= @fgets($file, 4096);  
  }  
  fclose ($file);  
}  
header('Content-Type: text/plain');
echo $url_content;
}
else{
$url = "indefinido";
echo $url;
}
?>  