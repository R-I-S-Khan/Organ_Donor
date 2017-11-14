<?php
require_once 'include/DB_Functions.php';
$db = new DB_Functions();
if (isset($_POST['name']) && isset($_POST['address']) && isset($_POST['donating_selling']) && isset($_POST['charging_price']) && isset($_POST['email'])&& isset($_POST['phone']))
{
$s1 = $_POST['name'];
$s2 = $_POST['address'];
$s3 = $_POST['donating_selling'];
$s4 = $_POST['charging_price'];
$s5 = $_POST['email'];
$s6 = $_POST['phone'];
$db->addTask($s1, $s2, $s3, $s4, $s5, $s6);
}
?>