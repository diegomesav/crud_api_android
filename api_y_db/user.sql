-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: bzvvkcov6crnqfgwwz9h-mysql.services.clever-cloud.com:3306
-- Tiempo de generación: 21-06-2024 a las 23:35:17
-- Versión del servidor: 8.0.22-13
-- Versión de PHP: 8.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bzvvkcov6crnqfgwwz9h`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `parentezco` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `nombre`, `correo`, `direccion`, `parentezco`) VALUES
(1434, 'Jack Johnson', 'jack.johnson@pruebacarga.com', ' 123 Main Street- Anytown- California- 12345', 'Abuelo'),
(1435, 'Emily Smith', 'emily.smith@pruebacarga.com', ' 456 Oak Avenue- Springfield- Illinois- 56789', 'Abuelo'),
(1436, 'Dylan Williams', 'dylan.williams@pruebacarga.com', ' 789 Elm Street- Rivertown- New York- 67890', 'Hermano'),
(1437, 'Madison Brown', 'madison.brown@pruebacarga.com', ' 101 Pine Street- Lakeside- Texas- 45678', 'Hijo'),
(1438, 'Ethan Davis', 'ethan.davis@pruebacarga.com', ' 202 Maple Drive- Mountainview- Oregon- 23456', 'Abuelo'),
(1439, 'Olivia Wilson', 'olivia.wilson@pruebacarga.com', ' 303 Cedar Lane- Riverdale- Georgia- 34567', 'Hermano'),
(1440, 'Mason Taylor', 'mason.taylor@pruebacarga.com', ' 404 Birch Street- Hillcrest- Arizona- 56789', 'Abuelo'),
(1441, 'Ava Jones', 'ava.jones@pruebacarga.com', ' 505 Walnut Avenue- Oakville- Washington- 45678', 'Hijo'),
(1442, 'Logan Miller', 'logan.miller@pruebacarga.com', ' 606 Elm Street- Willow Creek- Colorado- 67890', 'Padre'),
(1443, 'Sophia Moore', 'sophia.moore@pruebacarga.com', ' 707 Pine Drive- Cedarville- Montana- 34567', 'Abuelo'),
(1444, 'Carter Anderson', 'carter.anderson@pruebacarga.com', ' 808 Oak Avenue- Sunnyside- Florida- 23456', 'Abuelo'),
(1445, 'Isabella Martinez', 'isabella.martinez@pruebacarga.com', ' 909 Maple Drive- Maplewood- Texas- 45678', 'Abuelo'),
(1446, 'Wyatt Thompson', 'wyatt.thompson@pruebacarga.com', ' 111 Pine Street- Pineville- California- 56789', 'Hijo'),
(1447, 'Chloe White', 'chloe.white@pruebacarga.com', ' 121 Elm Street- Elmwood- Illinois- 67890', 'Hijo'),
(1448, 'Noah Garcia', 'noah.garcia@pruebacarga.com', ' 131 Oak Avenue- Oakdale- New York- 34567', 'Padre'),
(1449, 'Amelia Robinson', 'amelia.robinson@pruebacarga.com', ' 141 Maple Drive- Mapleton- Georgia- 45678', 'Hijo'),
(1450, 'Luke Clark', 'luke.clark@pruebacarga.com', ' 151 Cedar Lane- Clearwater- Arizona- 56789', 'Abuelo'),
(1451, 'Harper Hall', 'harper.hall@pruebacarga.com', ' 161 Birch Street- Birchwood- Washington- 67890', 'Padre'),
(1452, 'Owen Lewis', 'owen.lewis@pruebacarga.com', ' 171 Walnut Avenue- Walnut Grove- Colorado- 34567', 'Hijo'),
(1453, 'Abigail Carter', 'abigail.carter@pruebacarga.com', ' 181 Elm Street- Elmsville- Montana- 45678', 'Hermano'),
(1454, 'Jackson Adams', 'jackson.adams@pruebacarga.com', ' 191 Pine Drive- Pinehurst- Florida- 23456', 'Hermano'),
(1455, 'Charlotte Baker', 'charlotte.baker@pruebacarga.com', ' 202 Oak Avenue- Oakland- Texas- 56789', 'Abuelo'),
(1456, 'Caleb Mitchell', 'caleb.mitchell@pruebacarga.com', ' 212 Maple Drive- Maple Ridge- California- 67890', 'Hermano'),
(1457, 'Zoey Nelson', 'zoey.nelson@pruebacarga.com', ' 222 Cedar Lane- Cedar Hill- Illinois- 34567', 'Padre'),
(1458, 'Samuel Wright', 'samuel.wright@pruebacarga.com', ' 232 Birch Street- Birchfield- New York- 45678', 'Hijo'),
(1459, 'Lily Murphy', 'lily.murphy@pruebacarga.com', ' 242 Walnut Avenue- Walnut Springs- Georgia- 56789', 'Padre'),
(1460, 'Gabriel Scott', 'gabriel.scott@pruebacarga.com', ' 252 Elm Street- Elmdale- Arizona- 67890', 'Hermano'),
(1461, 'Addison Foster', 'addison.foster@pruebacarga.com', ' 262 Pine Drive- Pinefield- Washington- 34567', 'Padre'),
(1462, 'Benjamin Hayes', 'benjamin.hayes@pruebacarga.com', ' 272 Oak Avenue- Oakton- Colorado- 45678', 'Hijo'),
(1463, 'Grace Russell', 'grace.russell@pruebacarga.com', ' 282 Maple Drive- Mapleville- Montana- 56789', 'Hermano'),
(1464, 'Lucas Perry', 'lucas.perry@pruebacarga.com', ' 292 Cedar Lane- Cedarville- Florida- 67890', 'Hermano'),
(1465, 'Natalie Ross', 'natalie.ross@pruebacarga.com', ' 302 Birch Street- Birchwood- Texas- 34567', 'Padre'),
(1466, 'Aiden Evans', 'aiden.evans@pruebacarga.com', ' 312 Walnut Avenue- Walnut Creek- California- 45678', 'Hijo'),
(1467, 'Elizabeth Brooks', 'elizabeth.brooks@pruebacarga.com', ' 322 Elm Street- Elmhurst- Illinois- 56789', 'Hijo'),
(1468, 'Brayden Rivera', 'brayden.rivera@pruebacarga.com', ' 332 Oak Avenue- Oakwood- New York- 67890', 'Abuelo'),
(1469, 'Hannah Reed', 'hannah.reed@pruebacarga.com', ' 342 Maple Drive- Maplewood- Georgia- 34567', 'Hermano'),
(1470, 'Jayden Phillips', 'jayden.phillips@pruebacarga.com', ' 352 Cedar Lane- Cedartown- Arizona- 45678', 'Abuelo'),
(1471, 'Brooklyn Morgan', 'brooklyn.morgan@pruebacarga.com', ' 362 Birch Street- Birchville- Washington- 56789', 'Hijo'),
(1472, 'Isaac King', 'isaac.king@pruebacarga.com', ' 372 Walnut Avenue- Walnut Hill- Colorado- 67890', 'Padre'),
(1473, 'Sarah Olson', 'sarah.olson@pruebacarga.com', ' 382 Elm Street- Elmsdale- Montana- 34567', 'Hermano'),
(1476, 'Jackson King', 'ackson.king@pruebacarga.com', ' 789 Oak Street, Oakville, New York, 45678', 'Hijo'),
(1477, 'Scarlett Perez', 'scarlett.perez@pruebacarga.com', '432 Elm Street, Elmtree, New York, 45678', 'Hijo'),
(1478, 'Duver', 'duvermes@gmail.com', 'Djdjdjjdd', 'Padre');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1479;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
