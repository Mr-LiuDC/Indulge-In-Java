/*
Navicat MySQL Data Transfer

Source Server         : US_x64_1
Source Server Version : 50505
Source Host           : 192.168.159.128:3306
Source Database       : springboot_multi_table

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-03-17 14:43:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbc2qerk3l47javnl2yvn51uoi` (`user_id`),
  CONSTRAINT `FKbc2qerk3l47javnl2yvn51uoi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '床前明月光，疑是地上霜。举头望明月，低头思故乡。', '静夜思', '1');
INSERT INTO `article` VALUES ('2', '国破山河在，城春草木深。 感时花溅泪，恨别鸟惊心。 烽火连三月，家书抵万金。 白头搔更短，浑欲不胜簪。', '春望', '2');
INSERT INTO `article` VALUES ('3', '离离原上草，一岁一枯荣。 野火烧不尽，春风吹又生。 远芳侵古道，晴翠接荒城。 又送王孙去，萋萋满别情。', '草', '3');
INSERT INTO `article` VALUES ('4', '日照香炉生紫烟，遥看瀑布挂前川。 飞流直下三千尺，疑是银河落九天。', '望庐山瀑布', '1');
INSERT INTO `article` VALUES ('5', '好雨知时节，当春乃发生。 随风潜入夜，润物细无声。 野径云俱黑，江船火独明。 晓看红湿处，花重锦官城。', '春夜喜雨', '2');
INSERT INTO `article` VALUES ('6', '江南好，风景旧曾谙。日出江花红胜火，春来江水绿如蓝。能不忆江南？', '忆江南.江南好', '3');
INSERT INTO `article` VALUES ('7', '老夫聊发少年狂，左牵黄，右擎苍，锦帽貂裘，千骑卷平冈。为报倾城随太守，亲射虎，看孙郎。 酒酣胸胆尚开张，鬓微霜，又何妨！持节云中，何日遣冯唐？会挽雕弓如满月，西北望，射天狼。', '江城子·密州出猎', '4');
INSERT INTO `article` VALUES ('8', '李白乘舟将欲行，忽闻岸上踏歌声。 桃花潭水深千尺，不及汪伦送我情。', '赠汪伦', '1');
INSERT INTO `article` VALUES ('9', '两个黄鹂鸣翠柳，一行白鹭上青天。 窗含西岭千秋雪，门泊东吴万里船。', '绝句', '2');
INSERT INTO `article` VALUES ('10', '一道残阳铺水中，半江瑟瑟半江红。 可怜九月初三夜，露似真珠月似弓。', '暮江吟', '3');
INSERT INTO `article` VALUES ('11', '横看成岭侧成峰，远近高低各不同。 不识庐山真面目，只缘身在此山中。', '题西林壁', '4');
INSERT INTO `article` VALUES ('12', '朝辞白帝彩云间，千里江陵一日还。 两岸猿声啼不住，轻舟已过万重山。', '早发白帝城', '1');
INSERT INTO `article` VALUES ('13', '功盖三分国，名成八阵图。江流石不转，遗恨失吞吴。', '八阵图', '2');
INSERT INTO `article` VALUES ('14', '低花树映小妆楼，春入眉心两点愁。  斜倚栏干背鹦鹉，思量何事不回头。', '春词', '3');
INSERT INTO `article` VALUES ('15', '花褪残红青杏小。燕子飞时，绿水人家绕。枝上柳绵吹又少。天涯何处无芳草！ 墙里秋千墙外道。墙外行人，墙里佳人笑。笑渐不闻声渐悄。多情却被无情恼。', '蝶恋花·春景', '4');
INSERT INTO `article` VALUES ('16', '春宵一刻值千金，花有清香月有阴。 歌管楼台声细细，秋千院落夜沉沉。', '春宵', '4');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5yx0uphgjc6ik6hb82kkw501y` (`article_id`),
  KEY `FKhvh0e2ybgg16bpu229a5teje7` (`parent_comment_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK5yx0uphgjc6ik6hb82kkw501y` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKhvh0e2ybgg16bpu229a5teje7` FOREIGN KEY (`parent_comment_id`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '我想家了。', '1', null, '1');
INSERT INTO `comment` VALUES ('2', '四海为家。', '1', '1', '3');
INSERT INTO `comment` VALUES ('3', '说得轻巧，你到处漂泊试试。', '1', '2', '4');
INSERT INTO `comment` VALUES ('4', '就是，漂泊久了就会想家乡了。', '1', '3', '2');
INSERT INTO `comment` VALUES ('5', '家就是我们的港湾。', '1', '1', '2');
INSERT INTO `comment` VALUES ('6', '对啊，定期就要到港湾停靠才行。', '1', '5', '1');
INSERT INTO `comment` VALUES ('7', '为前辈点个赞。', '1', null, '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '李白', 'libai');
INSERT INTO `user` VALUES ('2', '杜甫', 'dufu');
INSERT INTO `user` VALUES ('3', '白居易', 'baijuyi');
INSERT INTO `user` VALUES ('4', '苏轼', 'sushi');
