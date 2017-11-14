<?php
class DB_Functions {
public function addTask($s1, $s2, $s3, $s4, $s5, $s6)
{
$link = mysqli_connect("127.0.0.1", "root", "buggyO08061995", "donor_database");
$query = "INSERT INTO donor_table (_name, _address, _donating_selling, _charging_price, _email, _phone) VALUES ('$s1', '$s2', '$s3', '$s4', '$s5', '$s6')";
$result = mysqli_query($link, $query);
$link->close();
}

public function getTasks()
{
$link = mysqli_connect("127.0.0.1", "root", "buggyO08061995", "donor_database");
$query = "SELECT * from donor_table";
$result = mysqli_query($link, $query);
$return_array = array();
while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
{
$row_array['id'] = $row['_id'];
$row_array['name'] = $row['_name'];
$row_array['address'] = $row['_address'];
$row_array['donating_selling'] = $row['_donating_selling'];
$row_array['charging_price'] = $row['_charging_price'];
$row_array['email'] = $row['_email'];
$row_array['phone'] = $row['_phone'];


array_push($return_array, $row_array);
}
error_reporting(E_ALL ^ E_DEPRECATED);
echo json_encode($return_array);
$link->close();
}
public function del($id)
{
$link = mysqli_connect("127.0.0.1", "root", "buggyO08061995", "donor_database");
$query = "DELETE FROM donor_table WHERE _id = '$id'";
$result = mysqli_query($link, $query);
$link->close();
}

}
?>