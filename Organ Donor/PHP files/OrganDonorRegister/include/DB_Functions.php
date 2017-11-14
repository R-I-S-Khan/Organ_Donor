<?php
class DB_Functions {
public function addTask($s1, $s2)
{
$link = mysqli_connect("127.0.0.1", "root", "buggyO08061995", "donor_register_database");
$query = "INSERT INTO donor_register_table (_name, _password) VALUES ('$s1', '$s2')";
$result = mysqli_query($link, $query);
$link->close();
}

public function getTasks()
{
$link = mysqli_connect("127.0.0.1", "root", "buggyO08061995", "donor_register_database");
$query = "SELECT * from donor_register_table";
$result = mysqli_query($link, $query);
$return_array = array();
while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
{
$row_array['id'] = $row['_id'];
$row_array['name'] = $row['_name'];
$row_array['password'] = $row['_password'];

array_push($return_array, $row_array);
}
error_reporting(E_ALL ^ E_DEPRECATED);
echo json_encode($return_array);
$link->close();
}
public function del($id)
{
$link = mysqli_connect("127.0.0.1", "root", "buggyO08061995", "donor_register_database");
$query = "DELETE FROM donor_register_table WHERE _id = '$id'";
$result = mysqli_query($link, $query);
$link->close();
}

}
?>