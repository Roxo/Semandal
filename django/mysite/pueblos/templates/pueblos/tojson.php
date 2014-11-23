<?php
$url="http://127.0.0.1:8000/api/pueblos/4/"; // url de la pagina que queremos obtener  
$url_content = '';  
$file = @fopen($url, 'r');  
if($file){  
  while(!feof($file)) {  
    $url_content .= @fgets($file, 4096);  
  }  
  fclose ($file);  
}
  echo url_content
?>
