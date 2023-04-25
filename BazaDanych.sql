-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 18 Kwi 2023, 15:28
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `product`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `bank`
--

CREATE TABLE `bank` (
  `id` int(11) NOT NULL,
  `capacity` varchar(5) NOT NULL,
  `blood_type` varchar(5) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `bank`
--

INSERT INTO `bank` (`id`, `capacity`, `blood_type`, `start_date`, `end_date`) VALUES
(1, '5l', 'Rh+', '2023-04-15', '2023-04-18');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `donor`
--

CREATE TABLE `donor` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `surname` varchar(25) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `blood_type` varchar(5) NOT NULL,
  `blood_given` varchar(5) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `surname` varchar(25) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `blood_type` varchar(5) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `patient`
--

INSERT INTO `patient` (`id`, `name`, `surname`, `age`, `email`, `blood_type`, `password`) VALUES
(1, 'Tom', 'Tomson', 42, 'tomson21@gmail.com', 'Rh-', 'grzyby12');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `transfusion`
--

CREATE TABLE `transfusion` (
  `transfusion_id` int(11) NOT NULL,
  `blood_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `transfusion`
--
ALTER TABLE `transfusion`
  ADD PRIMARY KEY (`transfusion_id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `bank`
--
ALTER TABLE `bank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `donor`
--
ALTER TABLE `donor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `transfusion`
--
ALTER TABLE `transfusion`
  MODIFY `transfusion_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
