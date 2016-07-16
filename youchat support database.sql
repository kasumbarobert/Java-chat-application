-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 16, 2016 at 03:33 
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `youchat`
--

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `msg_id` varchar(90) NOT NULL,
  `sender` varchar(30) NOT NULL,
  `msg` longtext,
  `file` text,
  `timestamp` bigint(20) NOT NULL,
  `receiver` varchar(30) NOT NULL,
  `read_status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`msg_id`, `sender`, `msg`, `file`, `timestamp`, `receiver`, `read_status`) VALUES
('andi_13?kasumbarobert_1', 'andi_13', 'Hello Robert mmag', NULL, 1464851108548, 'kasumbarobert', 1),
('andi_13?kasumbarobert_10', 'andi_13', 'Privity', 'uploaded_files/commands.txt', 1464946504657, 'kasumbarobert', 1),
('andi_13?kasumbarobert_2', 'andi_13', 'Hello Robert :) How are you for today', 'uploaded_files/LSBuguzi%20Application%20notes.docx_1odt', 1464851141097, 'kasumbarobert', 1),
('andi_13?kasumbarobert_3', 'andi_13', 'Hello there', NULL, 1464940355825, 'kasumbarobert', 1),
('andi_13?kasumbarobert_4', 'andi_13', 'Hdgfhjkas', NULL, 1464943757539, 'kasumbarobert', 1),
('andi_13?kasumbarobert_5', 'andi_13', 'Hello', NULL, 1464943794712, 'kasumbarobert', 1),
('andi_13?kasumbarobert_6', 'andi_13', 'solomon', NULL, 1464943881430, 'kasumbarobert', 1),
('andi_13?kasumbarobert_7', 'andi_13', 'solomon', NULL, 1464943891667, 'kasumbarobert', 1),
('andi_13?kasumbarobert_8', 'andi_13', 'hjj', NULL, 1464944018592, 'kasumbarobert', 1),
('andi_13?kasumbarobert_9', 'andi_13', 'hjj', NULL, 1464944026377, 'kasumbarobert', 1),
('ben?flash_1', 'ben', 'welcome', NULL, 1465291232502, 'flash', 1),
('ben?Georgia(2)_1', 'ben', 'hello', NULL, 1465244048948, 'Georgia(2)', 0),
('ben?Georgia_1', 'ben', 'Hello dear', NULL, 1464986621433, 'Georgia', 0),
('ben?Georgia_2', 'ben', 'How are you doing', NULL, 1464986711057, 'Georgia', 0),
('ben?Georgia_3', 'ben', 'Hello there', NULL, 1465236917998, 'Georgia', 0),
('ben?Georgia_4', 'ben', 'greeetings', NULL, 1465236931259, 'Georgia', 0),
('ben?Georgia_5', 'ben', 'hey', NULL, 1465236940005, 'Georgia', 0),
('ben?kasumbarobert_1', 'ben', 'hello bro', NULL, 1465241748733, 'kasumbarobert', 1),
('ben?kasumbarobert_2', 'ben', 'how are you?', NULL, 1465241826938, 'kasumbarobert', 1),
('ben?kasumbarobert_3', 'ben', 'Hey', NULL, 1465244125776, 'kasumbarobert', 1),
('ben?kasumbarobert_4', 'ben', 'hallo', NULL, 1465246645079, 'kasumbarobert', 1),
('ben?kasumbarobert_5', 'ben', 'Hallo boss', NULL, 1465400474189, 'kasumbarobert', 0),
('ben?kasumbarobert_6', 'ben', 'ben sent a file crap.txt to kasumbarobert at Wed Jun 08 18:41:15 EAT 2016', 'uploaded_files/crap.txt', 1465400475619, 'kasumbarobert', 0),
('ben?kasumba_5', 'ben', 'hello there', NULL, 1465287643636, 'kasumba', 1),
('ben?kjs_1', 'ben', 'hey', NULL, 1465399561140, 'kjs', 1),
('ben?lydiah_1', 'ben', 'hey', NULL, 1465288896257, 'lydiah', 1),
('ben?lydiah_2', 'ben', 'bonjour', NULL, 1465289746503, 'lydiah', 1),
('ben?lydiah_3', 'ben', 'am stuck man..', NULL, 1465290050033, 'lydiah', 1),
('ben?lydiah_4', 'ben', 'this work!', NULL, 1465290171255, 'lydiah', 1),
('ben?sandra_1', 'ben', 'hello sandra', NULL, 1465571156833, 'sandra', 0),
('Benevolent?Georgia_1', 'Benevolent', 'Hey there', NULL, 1464982040141, 'Georgia', 1),
('flash?God_1', 'flash', 'kk', NULL, 1465291187112, 'God', 0),
('flash?kjs_1', 'flash', '34567890-=-09876543', NULL, 1465291152877, 'kjs', 1),
('flash?kjs_2', 'flash', 'flash sent a file README.txt to kjs at Thu Jun 09 12:34:08 EAT 2016', 'uploaded_files/README.txt', 1465464848286, 'kjs', 1),
('Georgia?ben_1', 'Georgia', 'Yes', NULL, 1464986671627, 'ben', 1),
('Georgia?ben_2', 'Georgia', 'I am doing pretty fine :)', NULL, 1464986763319, 'ben', 1),
('Georgia?kasumbarobert_1', 'Georgia', 'hey, wass up', NULL, 1464986885673, 'kasumbarobert', 1),
('kasumba?ben_1', 'kasumba', 'Hallo Ben', NULL, 1465287059197, 'ben', 1),
('kasumba?ben_2', 'kasumba', 'hallo', NULL, 1465287162902, 'ben', 1),
('kasumba?ben_3', 'kasumba', 'Oli biki ggwe?', NULL, 1465287533863, 'ben', 1),
('kasumba?Georgia_1', 'kasumba', 'hope', NULL, 1465132042493, 'Georgia', 0),
('kasumba?kasumbarobert_1', 'kasumba', 'hey namesake', NULL, 1465132981278, 'kasumbarobert', 1),
('kasumba?kasumbarobert_2', 'kasumba', 'Wassup', NULL, 1465286474977, 'kasumbarobert', 1),
('kasumba?mike_1', 'kasumba', 'Hello', NULL, 1465132055172, 'mike', 1),
('kasumba?mutesasira_1', 'kasumba', 'It has worked', NULL, 1465132079136, 'mutesasira', 0),
('kasumba?sandra_1', 'kasumba', 'hello', NULL, 1465237884404, 'sandra', 1),
('kasumba?Ssevvume_1', 'kasumba', 'Hey Watsapp', NULL, 1465132067489, 'Ssevvume', 0),
('kasumbarobert?andi_13_1', 'kasumbarobert', 'Hey there, how are you doing', NULL, 1464869943695, 'andi_13', 1),
('kasumbarobert?andi_13_10', 'kasumbarobert', 'damn', NULL, 1464948368487, 'andi_13', 1),
('kasumbarobert?andi_13_11', 'kasumbarobert', 'trouble', NULL, 1464948454810, 'andi_13', 1),
('kasumbarobert?andi_13_12', 'kasumbarobert', 'more', NULL, 1464948468001, 'andi_13', 1),
('kasumbarobert?andi_13_13', 'kasumbarobert', 'I am trying to hustle', NULL, 1464949150904, 'andi_13', 1),
('kasumbarobert?andi_13_14', 'kasumbarobert', 'eh', NULL, 1464949215916, 'andi_13', 1),
('kasumbarobert?andi_13_15', 'kasumbarobert', 'hop', NULL, 1464949267359, 'andi_13', 1),
('kasumbarobert?andi_13_16', 'kasumbarobert', 'arg', NULL, 1464949299160, 'andi_13', 1),
('kasumbarobert?andi_13_17', 'kasumbarobert', 'noy', NULL, 1464949327111, 'andi_13', 1),
('kasumbarobert?andi_13_18', 'kasumbarobert', 'hey', NULL, 1464949432127, 'andi_13', 1),
('kasumbarobert?andi_13_19', 'kasumbarobert', 'k', NULL, 1464949517123, 'andi_13', 1),
('kasumbarobert?andi_13_2', 'kasumbarobert', 'Oh..sorry for wasting my time', NULL, 1464947074823, 'andi_13', 1),
('kasumbarobert?andi_13_20', 'kasumbarobert', 'not', NULL, 1464949744580, 'andi_13', 1),
('kasumbarobert?andi_13_21', 'kasumbarobert', 'Setting color: java.awt.Color[r=0,g=51,b=204]\nGraphics(6-1) Setting font: java.awt.Font[family=Dialog,name=Baskerville Old Face,style=bold,size=48]\nGraphics(8-1) Setting color: java.awt.Color[r=0,g=51,b=204]\nGraphics(8-1) Drawing string: "YouChat " at: java.awt.Point[x=0,y=45]\nSelect * FROM messages WHERE msg_id LIKE ''kasumbarobert?andi_13%'' OR', NULL, 1464973576219, 'andi_13', 1),
('kasumbarobert?andi_13_22', 'kasumbarobert', 'Hello\n', NULL, 1465215497983, 'andi_13', 1),
('kasumbarobert?andi_13_23', 'kasumbarobert', 'Hey', NULL, 1465286422581, 'andi_13', 1),
('kasumbarobert?andi_13_3', 'kasumbarobert', 'The test', NULL, 1464947815387, 'andi_13', 1),
('kasumbarobert?andi_13_4', 'kasumbarobert', 'more of the same', NULL, 1464947913307, 'andi_13', 1),
('kasumbarobert?andi_13_5', 'kasumbarobert', 'again ..this is interesting stuff', NULL, 1464948029631, 'andi_13', 1),
('kasumbarobert?andi_13_6', 'kasumbarobert', 'hehehee', NULL, 1464948143747, 'andi_13', 1),
('kasumbarobert?andi_13_7', 'kasumbarobert', 'hey', NULL, 1464948268423, 'andi_13', 1),
('kasumbarobert?andi_13_8', 'kasumbarobert', 'robe', NULL, 1464948293655, 'andi_13', 1),
('kasumbarobert?andi_13_9', 'kasumbarobert', 'sfghjsk', NULL, 1464948347161, 'andi_13', 1),
('kasumbarobert?ben_1', 'kasumbarobert', 'Hey there', NULL, 1465287233401, 'ben', 1),
('kasumbarobert?ben_2', 'kasumbarobert', 'hey', NULL, 1465287591095, 'ben', 1),
('kasumbarobert?Georgia_1', 'kasumbarobert', 'Hello dear', NULL, 1464981781019, 'Georgia', 0),
('kasumbarobert?Georgia_2', 'kasumbarobert', 'mugamba ki eyo', NULL, 1465198329885, 'Georgia', 0),
('kasumbarobert?Greg_1', 'kasumbarobert', 'Hey Snitch', NULL, 1465320764947, 'Greg', 0),
('kasumbarobert?kasumba_1', 'kasumbarobert', 'hello', NULL, 1465137991562, 'kasumba', 1),
('kasumbarobert?kasumba_2', 'kasumbarobert', 'how are you doing?', NULL, 1465138053937, 'kasumba', 1),
('kasumbarobert?lydiah_1', 'kasumbarobert', 'Hullalla', NULL, 1464869306810, 'lydiah', 1),
('kasumbarobert?lydiah_2', 'kasumbarobert', 'hey', NULL, 1465135409781, 'lydiah', 1),
('kasumbarobert?lydiah_3', 'kasumbarobert', 'thysus', NULL, 1465135511303, 'lydiah', 1),
('kasumbarobert?lydiah_4', 'kasumbarobert', 'thsisshs', NULL, 1465135526034, 'lydiah', 1),
('kasumbarobert?lydiah_5', 'kasumbarobert', 'hjsjjkskstb dusub sysbdsjisu', NULL, 1465135537045, 'lydiah', 1),
('kasumbarobert?lydiah_6', 'kasumbarobert', 'sghjs tsyjnst  zhklzbhzu jauajaa ', NULL, 1465135561589, 'lydiah', 1),
('kasumbarobert?lydiah_7', 'kasumbarobert', 'thsghshus ', NULL, 1465135575939, 'lydiah', 1),
('kasumbarobert?lydiah_8', 'kasumbarobert', 'shujksosmn ss', NULL, 1465135584680, 'lydiah', 1),
('kasumbarobert?lydiah_9', 'kasumbarobert', 'dundisnsjs', NULL, 1465135603948, 'lydiah', 1),
('kasumbarobert?mike_1', 'kasumbarobert', 'whw', NULL, 1465137487048, 'mike', 1),
('kasumbarobert?mike_2', 'kasumbarobert', 'hey', NULL, 1465137493922, 'mike', 1),
('kasumbarobert?mike_3', 'kasumbarobert', 'kasumbarobert sent a file LICENSE.txt to mike at Thu Jun 09 17:59:27 EAT 2016', 'uploaded_files/LICENSE.txt', 1465484367730, 'mike', 1),
('kasumbarobert?mike_4', 'kasumbarobert', 'Hey..Good evening for today!!', NULL, 1465484829407, 'mike', 1),
('kasumbarobert?owak_1', 'kasumbarobert', 'Oliwa???', NULL, 1464869321306, 'owak', 1),
('kasumbarobert?owak_2', 'kasumbarobert', 'ndi wano', NULL, 1465215995522, 'owak', 1),
('kasumbarobert?owak_3', 'kasumbarobert', 'good morning', NULL, 1465285827784, 'owak', 1),
('kasumbarobert?sandra_1', 'kasumbarobert', 'Come here tomorrow', NULL, 1464869337359, 'sandra', 1),
('kasumbarobert?sandra_2', 'kasumbarobert', 'wths sujks t shsbbs 7wbhsuss gssos sus d dyssjqewiww6902u 7309bsysybbs sui;sjsu7sbsjs6rbs  s s8ns0syhs i9gfgsbps   ysysns6wnps;;ls8ebsbijskpii', NULL, 1465207146170, 'sandra', 1),
('kjs?kasumbarobert_1', 'kjs', 'hallo', NULL, 1465242970831, 'kasumbarobert', 1),
('kjs?kjs_1', 'kjs', 'Enter the new message here', NULL, 1465464624620, 'kjs', 0),
('kjs?kjs_2', 'kjs', 'kjs sent a file LICENSE.txt to kjs at Thu Jun 09 12:30:26 EAT 2016', 'uploaded_files/LICENSE.txt', 1465464626304, 'kjs', 0),
('lydiah?ben_1', 'lydiah', 'bonjour...bon appetite', NULL, 1465289798876, 'ben', 1),
('lydiah?ben_2', 'lydiah', 'whats up?', NULL, 1465290068947, 'ben', 1),
('lydiah?ben_3', 'lydiah', 'hey..why are up this late?', NULL, 1465290791613, 'ben', 1),
('lydiah?Georgia_1', 'lydiah', 'how are you >3', NULL, 1465290014630, 'Georgia', 0),
('lydiah?mike_1', 'lydiah', 'hello', NULL, 1465289987147, 'mike', 1),
('mike?andi_13_1', 'mike', 'Is there a lecture tomorrow?', NULL, 1465324857056, 'andi_13', 1),
('mike?andi_13_2', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325259959, 'andi_13', 1),
('mike?andi_13_3', 'mike', 'Good evening', NULL, 1465325522501, 'andi_13', 1),
('mike?andi_13_4', 'mike', 'Hello people', NULL, 1465327402809, 'andi_13', 1),
('mike?andi_13_5', 'mike', 'Hey all', NULL, 1465546137223, 'andi_13', 0),
('mike?ben_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260008, 'ben', 1),
('mike?ben_2', 'mike', 'Good evening', NULL, 1465325522550, 'ben', 1),
('mike?ben_3', 'mike', 'Hello people', NULL, 1465327402856, 'ben', 1),
('mike?ben_4', 'mike', 'Hey all', NULL, 1465546137264, 'ben', 1),
('mike?flash_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260053, 'flash', 0),
('mike?flash_2', 'mike', 'Good evening', NULL, 1465325522606, 'flash', 0),
('mike?flash_3', 'mike', 'Hello people', NULL, 1465327402912, 'flash', 0),
('mike?flash_4', 'mike', 'Hey all', NULL, 1465546137309, 'flash', 0),
('mike?Georgia_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260097, 'Georgia', 0),
('mike?Georgia_2', 'mike', 'Good evening', NULL, 1465325522662, 'Georgia', 0),
('mike?Georgia_3', 'mike', 'Hello people', NULL, 1465327402968, 'Georgia', 0),
('mike?Georgia_4', 'mike', 'Hey all', NULL, 1465546137353, 'Georgia', 0),
('mike?God_1', 'mike', 'Hello Jesus, everything is against me in this world, what can i do?', NULL, 1465238047647, 'God', 0),
('mike?God_2', 'mike', 'Will I ever be alright?', NULL, 1465238074512, 'God', 0),
('mike?God_3', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260142, 'God', 0),
('mike?God_4', 'mike', 'Good evening', NULL, 1465325522717, 'God', 0),
('mike?God_5', 'mike', 'Hello people', NULL, 1465327403023, 'God', 0),
('mike?God_6', 'mike', 'Hey all', NULL, 1465546137398, 'God', 0),
('mike?Greg_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260186, 'Greg', 0),
('mike?Greg_2', 'mike', 'Good evening', NULL, 1465325522773, 'Greg', 0),
('mike?Greg_3', 'mike', 'Hello people', NULL, 1465327403079, 'Greg', 0),
('mike?Greg_4', 'mike', 'Hey all', NULL, 1465546137443, 'Greg', 0),
('mike?kasumbarobert_1', 'mike', 'hallo\n', NULL, 1465237528011, 'kasumbarobert', 1),
('mike?kasumbarobert_10', 'mike', 'Hey all', NULL, 1465546137532, 'kasumbarobert', 0),
('mike?kasumbarobert_2', 'mike', 'how are you?', NULL, 1465237543118, 'kasumbarobert', 1),
('mike?kasumbarobert_3', 'mike', 'hallo', NULL, 1465241669873, 'kasumbarobert', 1),
('mike?kasumbarobert_4', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260276, 'kasumbarobert', 1),
('mike?kasumbarobert_5', 'mike', 'Good evening', NULL, 1465325522884, 'kasumbarobert', 1),
('mike?kasumbarobert_6', 'mike', 'Hello people', NULL, 1465327403178, 'kasumbarobert', 1),
('mike?kasumbarobert_7', 'mike', 'hi', NULL, 1465399279591, 'kasumbarobert', 1),
('mike?kasumbarobert_8', 'mike', 'hey', NULL, 1465399933077, 'kasumbarobert', 1),
('mike?kasumbarobert_9', 'mike', 'mike sent a file crap.txt to kasumbarobert at Wed Jun 08 18:32:15 EAT 2016', NULL, 1465399935221, 'kasumbarobert', 1),
('mike?kasumba_11', 'mike', 'ggwe', NULL, 1465399342035, 'kasumba', 0),
('mike?kasumba_14', 'mike', 'Hey all', NULL, 1465546137487, 'kasumba', 0),
('mike?kasumba_4', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260231, 'kasumba', 0),
('mike?kasumba_6', 'mike', 'Good evening', NULL, 1465325522829, 'kasumba', 0),
('mike?kasumba_8', 'mike', 'Hello people', NULL, 1465327403134, 'kasumba', 0),
('mike?kjs_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260320, 'kjs', 1),
('mike?kjs_2', 'mike', 'Good evening', NULL, 1465325522940, 'kjs', 1),
('mike?kjs_3', 'mike', 'Hello people', NULL, 1465327403223, 'kjs', 1),
('mike?kjs_4', 'mike', 'Hello..Good morning', NULL, 1465375626540, 'kjs', 1),
('mike?kjs_5', 'mike', 'Hey all', NULL, 1465546137576, 'kjs', 0),
('mike?lydiah_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260365, 'lydiah', 0),
('mike?lydiah_2', 'mike', 'Good evening', NULL, 1465325522996, 'lydiah', 0),
('mike?lydiah_3', 'mike', 'Hello people', NULL, 1465327403280, 'lydiah', 0),
('mike?lydiah_4', 'mike', 'Hey all', NULL, 1465546137621, 'lydiah', 0),
('mike?mutesasira_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260409, 'mutesasira', 0),
('mike?mutesasira_2', 'mike', 'Good evening', NULL, 1465325523052, 'mutesasira', 0),
('mike?mutesasira_3', 'mike', 'Hello people', NULL, 1465327403335, 'mutesasira', 0),
('mike?mutesasira_4', 'mike', 'Hey all', NULL, 1465546137676, 'mutesasira', 0),
('mike?owak_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260454, 'owak', 1),
('mike?owak_2', 'mike', 'Good evening', NULL, 1465325523107, 'owak', 1),
('mike?owak_3', 'mike', 'hey...I dont know', NULL, 1465325567350, 'owak', 1),
('mike?owak_4', 'mike', 'Hello people', NULL, 1465327403390, 'owak', 0),
('mike?owak_5', 'mike', 'Hey all', NULL, 1465546137732, 'owak', 0),
('mike?sandra_1', 'mike', 'Heye...watsaap..stuff is hard! I am missing you, when are you coming to see me. But even the last time you came you spent little time..even my mother wanted to see you but you had gone', NULL, 1465031670736, 'sandra', 1),
('mike?sandra_10', 'mike', 'Hey Sandra, I am testing this', NULL, 1465570461232, 'sandra', 0),
('mike?sandra_2', 'mike', 'hope', NULL, 1465135237845, 'sandra', 1),
('mike?sandra_3', 'mike', 'Hello dear, how are you doing?', NULL, 1465204784893, 'sandra', 1),
('mike?sandra_4', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260498, 'sandra', 1),
('mike?sandra_5', 'mike', 'Good evening', NULL, 1465325523163, 'sandra', 1),
('mike?sandra_6', 'mike', 'Hello people', NULL, 1465327403446, 'sandra', 1),
('mike?sandra_7', 'mike', 'hello there', NULL, 1465395667462, 'sandra', 1),
('mike?sandra_8', 'mike', 'i dont know how to reply', NULL, 1465395742305, 'sandra', 1),
('mike?sandra_9', 'mike', 'Hey all', NULL, 1465546137788, 'sandra', 1),
('mike?Ssevvume_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260543, 'Ssevvume', 0),
('mike?Ssevvume_2', 'mike', 'Good evening', NULL, 1465325523219, 'Ssevvume', 0),
('mike?Ssevvume_3', 'mike', 'Hello people', NULL, 1465327403501, 'Ssevvume', 0),
('mike?Ssevvume_4', 'mike', 'Hey all', NULL, 1465546137843, 'Ssevvume', 0),
('mike?stella_1', 'mike', 'Hey..what are you up to at this tym?', NULL, 1465325260588, 'stella', 0),
('mike?stella_2', 'mike', 'Good evening', NULL, 1465325523274, 'stella', 0),
('mike?stella_3', 'mike', 'Hello people', NULL, 1465327403558, 'stella', 0),
('mike?stella_4', 'mike', 'Hey all', NULL, 1465546137899, 'stella', 0),
('mike?tmt_1', 'mike', 'Hey all', NULL, 1465546137955, 'tmt', 0),
('owak?kasumbarobert_1', 'owak', 'hello', NULL, 1465285761950, 'kasumbarobert', 1),
('owak?mike_1', 'owak', 'rfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffjhiiohi9g9ilkj', NULL, 1465325603019, 'mike', 1),
('owak?sandra_1', 'owak', 'ewrtyuiop[]selfkosiuyefgfiihwje;ofhpwehffksn;dfkvhlsiugvidblsiglegh;hwlfiqgwilnkjhgfdfghjklx;x''v.ghkfdiyghbnm,hj;k\n''[hpgogidursyeghsvbnc,mvc.;gh[potiuereshgdbxnc,vml;ghpoifuyhcjvnv,ml;''gf[p0r9e8utwyafsbvndmf,;lghy0t98reytwagsvbnmd,f.[hj]uty0p9iruegshzbnm,f.gl;9yt8iuegashjdklf;hgpy9oot8ieysghakjdlf;gypotiurehgsdbnmx,fklg;hypotiuerhgsndmkfl;yotpiuerhsgadklf;goioufdreshabnmd,f;lghpogiuregwhejkrlt;ypotierhj', NULL, 1465199239622, 'sandra', 1),
('owak?sandra_2', 'owak', '[9iuytresdxfcgvghjk[p[oiuytdrtyuioo]p]o[09p8yutyrxcvhjk''\n[[up98y7t6dytufgiuiohjpok[l', NULL, 1465199460064, 'sandra', 1),
('sand?andi_13_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547439956, 'andi_13', 0),
('sand?ben_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440001, 'ben', 1),
('sand?flash_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440046, 'flash', 0),
('sand?Georgia_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440090, 'Georgia', 0),
('sand?God_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440135, 'God', 0),
('sand?Greg_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440180, 'Greg', 0),
('sand?kasumbarobert_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440269, 'kasumbarobert', 0),
('sand?kasumba_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440224, 'kasumba', 0),
('sand?kjs_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440313, 'kjs', 0),
('sand?lydiah_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440358, 'lydiah', 0),
('sand?mike_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440402, 'mike', 0),
('sand?mutesasira_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440447, 'mutesasira', 0),
('sand?owak_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440492, 'owak', 0),
('sand?sandra_1', 'sand', 'tryuuyiohgfggj', NULL, 1465547147038, 'sandra', 1),
('sand?sandra_2', 'sand', 'tyiddbvhdkkok', NULL, 1465547440536, 'sandra', 1),
('sand?Ssevvume_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440581, 'Ssevvume', 0),
('sand?stella_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440625, 'stella', 0),
('sand?tmt_1', 'sand', 'tyiddbvhdkkok', NULL, 1465547440670, 'tmt', 0),
('sandra?ben_1', 'sandra', 'Hello Ben', NULL, 1465571004536, 'ben', 1),
('sandra?ben_2', 'sandra', 'Hope you are doing good>>', NULL, 1465571174732, 'ben', 1),
('sandra?kasumbarobert_1', 'sandra', 'hello', NULL, 1465205670966, 'kasumbarobert', 1),
('sandra?kasumbarobert_2', 'sandra', 'agkjnjau syi w8w uwygw  t7uwbbuowo syiwns6hh sy6sbsnsyte s7snnsiiksutft sysuis hytus sysis ysus sysi y86 pwuw sywuiw  susypsb y8wisn syshh', NULL, 1465207212186, 'kasumbarobert', 1),
('sandra?kasumbarobert_3', 'sandra', 'hey there Robert', NULL, 1465236236946, 'kasumbarobert', 1),
('sandra?kasumbarobert_4', 'sandra', 'hallo', NULL, 1465247758164, 'kasumbarobert', 1),
('sandra?kasumba_4', 'sandra', 'hello', NULL, 1465237825992, 'kasumba', 1),
('sandra?kasumba_5', 'sandra', 'hello, did you finish the work\n', NULL, 1465237950828, 'kasumba', 1),
('sandra?kasumba_6', 'sandra', 'How was it?', NULL, 1465237966106, 'kasumba', 1),
('sandra?kjs_1', 'sandra', 'hey fala', NULL, 1465248028320, 'kjs', 1),
('sandra?mike_1', 'sandra', 'yuio', NULL, 1465031559103, 'mike', 1),
('sandra?mike_2', 'sandra', 'I am doing great', NULL, 1465206068101, 'mike', 1),
('sandra?mike_3', 'sandra', 'Hjsklso-[=- suuns  suos shsy8sbs sis pms sysfjs  sh8ywbwkow[w=w wywi w pw[ww77wnw sywins tss spddytuskspe77ss ', NULL, 1465206904939, 'mike', 1),
('sandra?mike_4', 'sandra', 'hey', NULL, 1465237398464, 'mike', 1),
('sandra?mike_5', 'sandra', 'bonjour', NULL, 1465395688391, 'mike', 1),
('sandra?mike_6', 'sandra', 'Hello Mike', NULL, 1465546114020, 'mike', 1),
('sandra?mike_7', 'sandra', 'sandra sent a file README.txt to mike at Fri Jun 10 11:10:08 EAT 2016', 'uploaded_files/README.txt', 1465546208841, 'mike', 1),
('sandra?owak_1', 'sandra', ',,kiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii', NULL, 1465199433730, 'owak', 1),
('sandra?sand_1', 'sandra', 'dfstdgudydgtydf', NULL, 1465547198310, 'sand', 1),
('sandra?sand_2', 'sandra', 'This is the reply', NULL, 1465547309983, 'sand', 1),
('sandra?sand_3', 'sandra', 'sandra sent a file testFile.txt to sand at Fri Jun 10 11:32:49 EAT 2016', 'uploaded_files/testFile.txt', 1465547569621, 'sand', 0),
('sandra?Ssevvume_1', 'sandra', 'Hello there', NULL, 1465237447707, 'Ssevvume', 0),
('sandra?Ssevvume_2', 'sandra', 'how are you doing', NULL, 1465237463362, 'Ssevvume', 0),
('Snitch?Georgia_1', 'Snitch', 'Heye', NULL, 1464985369523, 'Georgia', 0),
('Snitch?Georgia_2', 'Snitch', 'hwjshsy', NULL, 1464985387359, 'Georgia', 0),
('Solomon?ben_1', 'Solomon', 'Hello', NULL, 1464982109264, 'ben', 0),
('Solomon?ben_2', 'Solomon', 'hello', NULL, 1464985006318, 'ben', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `name` varchar(90) NOT NULL,
  `password` mediumtext NOT NULL,
  `login_status` int(1) NOT NULL DEFAULT '0',
  `profile_photo` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `name`, `password`, `login_status`, `profile_photo`) VALUES
('andi_13', 'Richards Andrew', '12', 0, 'prof_photos/images (4.jpg'),
('ben', 'Benevolent', '1', 1, 'prof_photos/aganaga-1.png'),
('flash', 'flavia', 'me', 0, 'prof_photos/download3.png'),
('Georgia', 'Solomon', '1', 0, 'prof_photos/aganaga-1.png'),
('God', 'Jesus', '1', 0, 'prof_photos/Winnie-Nwagi.png'),
('Greg', 'Snitch', '1', 0, 'prof_photos/r-tym.png'),
('kasumba', 'Robert', '1', 0, 'prof_photos/aganaga-1.png'),
('kasumbarobert', 'Kasumba Robert', 'lydia12', 0, 'prof_photos/2015-06-27 11.40.46.png'),
('kjs', 'albert', 'sdf', 0, 'prof_photos/download3.png'),
('lydiah', 'Kasumba', '1', 0, 'prof_photos/aganaga-1.png'),
('mike', 'Nicklaus', '1', 1, 'prof_photos/Winnie-Nwagi.png'),
('mutesasira', 'Albert', '1', 0, 'prof_photos/aganaga-1.png'),
('owak', 'Eugene', '1', 0, 'prof_photos/Screenshot_2015-04-24-22-08-58.png'),
('sand', 'nyazisandrahma', '1234', 0, ''),
('sandra', 'Nyamaizi', '1', 1, 'prof_photos/Winnie-Nwagi.png'),
('Ssevvume', 'Solomon', '1', 0, 'prof_photos/gems_algorithm_2.png'),
('stella', 'Mamdan', '1', 0, ''),
('tmt', 'The MT', 'tmt', 0, 'prof_photos/trial.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
