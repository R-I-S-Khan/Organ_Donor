<?php
if (isset($_POST['A']) && isset($_POST['B'])) {
$a = $_POST['A'];
$b = $_POST['B'];
$response["sum"] = $a + $b;
echo json_encode($response);
}
?>