<?php

$host = '127.0.0.1';
$port = '3306';
$bdd = 'dev_web_but2';
$user = 'root';
$pass = '';

$conn = new PDO(
    "mysql:host=$host;
     port=$port;dbname=$bdd",
    "$user",
    "$pass"
    );
?>
