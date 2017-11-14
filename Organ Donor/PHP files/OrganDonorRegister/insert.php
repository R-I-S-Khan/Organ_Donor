<?php
require_once 'include/DB_Functions.php';
$db = new DB_Functions();
if (isset($_POST['name']) && isset($_POST['password']))
{
$s1 = $_POST['name'];
$s2 = $_POST['password'];
$db->addTask($s1, $s2);
}
?>