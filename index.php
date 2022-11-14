<?php
    require '../include/Flight/flight/Flight.php';
    require '../include/Smarty/libs/Smarty.class.php';
    require '../include/pdo.php';
    require './routes.php';

    Flight::set('conn', $conn);
    Flight::register('view', 'Smarty', array(), function($smarty){
        $smarty->template_dir = './templates/';
        $smarty->compile_dir = './templates_c/';
        $smarty->config_dir = './config/';
        $smarty->cache_dir = './cache/';
    });

    //ajoute une méthode render à Flight qui affiche un template
    //en lui transmettant un tableau de données
    Flight::map('render', function($template, $data){
        Flight::view()->assign($data);
        Flight::view()->display($template);
    });

    Flight::start();

?>