<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="upload a file to the server">
    <meta name="author" content="dineth egodage">

    <title>Upload File</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
   </head>

  <body>
	<form method="post" enctype="multipart/form-data">
		<table width="350" border="0" cellpadding="1" cellspacing="1" class="box">
			<tr>
				<td width="246">
					<input type="hidden" name="MAX_FILE_SIZE" value="2000000">
					<input name="userfile" type="file" id="userfile">
				</td>
				<td width="80"><input name="upload" type="submit" class="box" id="upload" value=" Upload "></td>
			</tr>
		</table>
	</form>
  </body>
</html>

<?php
if(isset($_POST['upload']) && $_FILES['userfile']['size'] > 0)
{
$fileName = $_FILES['userfile']['name'];
$tmpName  = $_FILES['userfile']['tmp_name'];
$fileSize = $_FILES['userfile']['size'];
$fileType = $_FILES['userfile']['type'];

$fp      = fopen($tmpName, 'r');
$content = fread($fp, filesize($tmpName));
$content = addslashes($content);
fclose($fp);

if(!get_magic_quotes_gpc())
{
    $fileName = addslashes($fileName);
}

include 'config.php';

$query = "INSERT INTO upload (name, size, type, content ) ".
"VALUES ('$fileName', '$fileSize', '$fileType', '$content')";

mysql_query($query) or die('Error, query failed');

diconnectDb();

echo "<br>File $fileName uploaded<br>";
}
?>

