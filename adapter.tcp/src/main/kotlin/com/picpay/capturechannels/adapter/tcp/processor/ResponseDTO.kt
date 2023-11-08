package com.picpay.capturechannels.adapter.tcp.processor

import com.fasterxml.jackson.annotation.JsonProperty
import com.picpay.capturechannels.adapter.tcp.service.TcpAdapterService

data class ResponseDTO(
    @JsonProperty("codMsg")
    @TcpAdapterService.IsoField(0)
    val codMsg: String?,
    @JsonProperty("BIT_01")
    @TcpAdapterService.IsoField(1)
    val bit01: String? = null,
    @JsonProperty("BIT_02")
    @TcpAdapterService.IsoField(2)
    val bit02: String? = null,
    @JsonProperty("BIT_03")
    @TcpAdapterService.IsoField(3)
    val bit03: String? = null,
    @JsonProperty("BIT_04")
    @TcpAdapterService.IsoField(4)
    val bit04: String? = null,
    @JsonProperty("BIT_05")
    @TcpAdapterService.IsoField(5)
    val bit05: String? = null,
    @JsonProperty("BIT_06")
    @TcpAdapterService.IsoField(6)
    val bit06: String? = null,
    @JsonProperty("BIT_07")
    @TcpAdapterService.IsoField(7)
    val bit07: String? = null,
    @JsonProperty("BIT_08")
    @TcpAdapterService.IsoField(8)
    val bit08: String? = null,
    @JsonProperty("BIT_09")
    @TcpAdapterService.IsoField(9)
    val bit09: String? = null,
    @JsonProperty("BIT_10")
    @TcpAdapterService.IsoField(10)
    val bit10: String? = null,
    @JsonProperty("BIT_11")
    @TcpAdapterService.IsoField(11)
    val bit11: String? = null,
    @JsonProperty("BIT_12")
    @TcpAdapterService.IsoField(12)
    val bit12: String? = null,
    @JsonProperty("BIT_13")
    @TcpAdapterService.IsoField(13)
    val bit13: String? = null,
    @JsonProperty("BIT_14")
    @TcpAdapterService.IsoField(14)
    val bit14: String? = null,
    @JsonProperty("BIT_15")
    @TcpAdapterService.IsoField(15)
    val bit15: String? = null,
    @JsonProperty("BIT_16")
    @TcpAdapterService.IsoField(16)
    val bit16: String? = null,
    @JsonProperty("BIT_17")
    @TcpAdapterService.IsoField(17)
    val bit17: String? = null,
    @JsonProperty("BIT_18")
    @TcpAdapterService.IsoField(18)
    val bit18: String? = null,
    @JsonProperty("BIT_19")
    @TcpAdapterService.IsoField(19)
    val bit19: String? = null,
    @JsonProperty("BIT_20")
    @TcpAdapterService.IsoField(20)
    val bit20: String? = null,
    @JsonProperty("BIT_21")
    @TcpAdapterService.IsoField(21)
    val bit21: String? = null,
    @JsonProperty("BIT_22")
    @TcpAdapterService.IsoField(22)
    val bit22: String? = null,
    @JsonProperty("BIT_23")
    @TcpAdapterService.IsoField(23)
    val bit23: String? = null,
    @JsonProperty("BIT_24")
    @TcpAdapterService.IsoField(24)
    val bit24: String? = null,
    @JsonProperty("BIT_25")
    @TcpAdapterService.IsoField(25)
    val bit25: String? = null,
    @JsonProperty("BIT_26")
    @TcpAdapterService.IsoField(26)
    val bit26: String? = null,
    @JsonProperty("BIT_27")
    @TcpAdapterService.IsoField(27)
    val bit27: String? = null,
    @JsonProperty("BIT_28")
    @TcpAdapterService.IsoField(28)
    val bit28: String? = null,
    @JsonProperty("BIT_29")
    @TcpAdapterService.IsoField(29)
    val bit29: String? = null,
    @JsonProperty("BIT_30")
    @TcpAdapterService.IsoField(30)
    val bit30: String? = null,
    @JsonProperty("BIT_31")
    @TcpAdapterService.IsoField(31)
    val bit31: String? = null,
    @JsonProperty("BIT_32")
    @TcpAdapterService.IsoField(32)
    val bit32: String? = null,
    @JsonProperty("BIT_33")
    @TcpAdapterService.IsoField(33)
    val bit33: String? = null,
    @JsonProperty("BIT_34")
    @TcpAdapterService.IsoField(34)
    val bit34: String? = null,
    @JsonProperty("BIT_35")
    @TcpAdapterService.IsoField(35)
    val bit35: String? = null,
    @JsonProperty("BIT_36")
    @TcpAdapterService.IsoField(36)
    val bit36: String? = null,
    @JsonProperty("BIT_37")
    @TcpAdapterService.IsoField(37)
    val bit37: String? = null,
    @JsonProperty("BIT_38")
    @TcpAdapterService.IsoField(38)
    val bit38: String? = null,
    @JsonProperty("BIT_39")
    @TcpAdapterService.IsoField(39)
    val bit39: String? = null,
    @JsonProperty("BIT_40")
    @TcpAdapterService.IsoField(40)
    val bit40: String? = null,
    @JsonProperty("BIT_41")
    @TcpAdapterService.IsoField(41)
    val bit41: String? = null,
    @JsonProperty("BIT_42")
    @TcpAdapterService.IsoField(42)
    val bit42: String? = null,
    @JsonProperty("BIT_43")
    @TcpAdapterService.IsoField(43)
    val bit43: String? = null,
    @JsonProperty("BIT_44")
    @TcpAdapterService.IsoField(44)
    val bit44: String? = null,
    @JsonProperty("BIT_45")
    @TcpAdapterService.IsoField(45)
    val bit45: String? = null,
    @JsonProperty("BIT_46")
    @TcpAdapterService.IsoField(46)
    val bit46: String? = null,
    @JsonProperty("BIT_47")
    @TcpAdapterService.IsoField(47)
    val bit47: String? = null,
    @JsonProperty("BIT_48")
    @TcpAdapterService.IsoField(48)
    val bit48: String? = null,
    @JsonProperty("BIT_49")
    @TcpAdapterService.IsoField(49)
    val bit49: String? = null,
    @JsonProperty("BIT_50")
    @TcpAdapterService.IsoField(50)
    val bit50: String? = null,
    @JsonProperty("BIT_51")
    @TcpAdapterService.IsoField(51)
    val bit51: String? = null,
    @JsonProperty("BIT_52")
    @TcpAdapterService.IsoField(52)
    val bit52: String? = null,
    @JsonProperty("BIT_53")
    @TcpAdapterService.IsoField(53)
    val bit53: String? = null,
    @JsonProperty("BIT_54")
    @TcpAdapterService.IsoField(54)
    val bit54: String? = null,
    @JsonProperty("BIT_55")
    @TcpAdapterService.IsoField(55)
    val bit55: String? = null,
    @JsonProperty("BIT_56")
    @TcpAdapterService.IsoField(56)
    val bit56: String? = null,
    @JsonProperty("BIT_57")
    @TcpAdapterService.IsoField(57)
    val bit57: String? = null,
    @JsonProperty("BIT_58")
    @TcpAdapterService.IsoField(58)
    val bit58: String? = null,
    @JsonProperty("BIT_59")
    @TcpAdapterService.IsoField(59)
    val bit59: String? = null,
    @JsonProperty("BIT_60")
    @TcpAdapterService.IsoField(60)
    val bit60: String? = null,
    @JsonProperty("BIT_61")
    @TcpAdapterService.IsoField(61)
    val bit61: String? = null,
    @JsonProperty("BIT_62")
    @TcpAdapterService.IsoField(62)
    val bit62: String? = null,
    @JsonProperty("BIT_63")
    @TcpAdapterService.IsoField(63)
    val bit63: String? = null,
    @JsonProperty("BIT_64")
    @TcpAdapterService.IsoField(64)
    val bit64: String? = null,
    @JsonProperty("BIT_65")
    @TcpAdapterService.IsoField(65)
    val bit65: String? = null,
    @JsonProperty("BIT_66")
    @TcpAdapterService.IsoField(66)
    val bit66: String? = null,
    @JsonProperty("BIT_67")
    @TcpAdapterService.IsoField(67)
    val bit67: String? = null,
    @JsonProperty("BIT_68")
    @TcpAdapterService.IsoField(68)
    val bit68: String? = null,
    @JsonProperty("BIT_69")
    @TcpAdapterService.IsoField(69)
    val bit69: String? = null,
    @JsonProperty("BIT_70")
    @TcpAdapterService.IsoField(70)
    var bit70: String? = null,
    @JsonProperty("BIT_71")
    @TcpAdapterService.IsoField(71)
    val bit71: String?,
    @JsonProperty("BIT_72")
    @TcpAdapterService.IsoField(72)
    val bit72: String? = null,
    @JsonProperty("BIT_73")
    @TcpAdapterService.IsoField(73)
    val bit73: String? = null,
    @JsonProperty("BIT_74")
    @TcpAdapterService.IsoField(74)
    val bit74: String? = null,
    @JsonProperty("BIT_75")
    @TcpAdapterService.IsoField(75)
    val bit75: String? = null,
    @JsonProperty("BIT_76")
    @TcpAdapterService.IsoField(76)
    val bit76: String? = null,
    @JsonProperty("BIT_77")
    @TcpAdapterService.IsoField(77)
    val bit77: String? = null,
    @JsonProperty("BIT_78")
    @TcpAdapterService.IsoField(78)
    val bit78: String? = null,
    @JsonProperty("BIT_79")
    @TcpAdapterService.IsoField(79)
    val bit79: String? = null,
    @JsonProperty("BIT_80")
    @TcpAdapterService.IsoField(80)
    val bit80: String? = null,
    @JsonProperty("BIT_81")
    @TcpAdapterService.IsoField(81)
    val bit81: String? = null,
    @JsonProperty("BIT_82")
    @TcpAdapterService.IsoField(82)
    val bit82: String? = null,
    @JsonProperty("BIT_83")
    @TcpAdapterService.IsoField(83)
    val bit83: String? = null,
    @JsonProperty("BIT_84")
    @TcpAdapterService.IsoField(84)
    val bit84: String? = null,
    @JsonProperty("BIT_85")
    @TcpAdapterService.IsoField(85)
    val bit85: String? = null,
    @JsonProperty("BIT_86")
    @TcpAdapterService.IsoField(86)
    val bit86: String? = null,
    @JsonProperty("BIT_87")
    @TcpAdapterService.IsoField(87)
    val bit87: String? = null,
    @JsonProperty("BIT_88")
    @TcpAdapterService.IsoField(88)
    val bit88: String? = null,
    @JsonProperty("BIT_89")
    @TcpAdapterService.IsoField(89)
    val bit89: String? = null,
    @JsonProperty("BIT_90")
    @TcpAdapterService.IsoField(90)
    val bit90: String? = null,
    @JsonProperty("BIT_91")
    @TcpAdapterService.IsoField(91)
    val bit91: String? = null,
    @JsonProperty("BIT_92")
    @TcpAdapterService.IsoField(92)
    val bit92: String? = null,
    @JsonProperty("BIT_93")
    @TcpAdapterService.IsoField(93)
    val bit93: String? = null,
    @JsonProperty("BIT_94")
    @TcpAdapterService.IsoField(94)
    val bit94: String? = null,
    @JsonProperty("BIT_95")
    @TcpAdapterService.IsoField(95)
    val bit95: String? = null,
    @JsonProperty("BIT_96")
    @TcpAdapterService.IsoField(96)
    val bit96: String? = null,
    @JsonProperty("BIT_97")
    @TcpAdapterService.IsoField(97)
    val bit97: String? = null,
    @JsonProperty("BIT_98")
    @TcpAdapterService.IsoField(98)
    val bit98: String? = null,
    @JsonProperty("BIT_99")
    @TcpAdapterService.IsoField(99)
    val bit99: String? = null,
    @JsonProperty("BIT_100")
    @TcpAdapterService.IsoField(100)
    val bit100: String? = null,
    @JsonProperty("BIT_101")
    @TcpAdapterService.IsoField(101)
    val bit101: String? = null,
    @JsonProperty("BIT_102")
    @TcpAdapterService.IsoField(102)
    val bit102: String? = null,
    @JsonProperty("BIT_103")
    @TcpAdapterService.IsoField(103)
    val bit103: String? = null,
    @JsonProperty("BIT_104")
    @TcpAdapterService.IsoField(104)
    val bit104: String? = null,
    @JsonProperty("BIT_105")
    @TcpAdapterService.IsoField(105)
    val bit105: String? = null,
    @JsonProperty("BIT_106")
    @TcpAdapterService.IsoField(106)
    val bit106: String? = null,
    @JsonProperty("BIT_107")
    @TcpAdapterService.IsoField(107)
    val bit107: String? = null,
    @JsonProperty("BIT_108")
    @TcpAdapterService.IsoField(108)
    val bit108: String? = null,
    @JsonProperty("BIT_109")
    @TcpAdapterService.IsoField(109)
    val bit109: String? = null,
    @JsonProperty("BIT_110")
    @TcpAdapterService.IsoField(110)
    val bit110: String? = null,
    @JsonProperty("BIT_111")
    @TcpAdapterService.IsoField(111)
    val bit111: String? = null,
    @JsonProperty("BIT_112")
    @TcpAdapterService.IsoField(112)
    val bit112: String? = null,
    @JsonProperty("BIT_113")
    @TcpAdapterService.IsoField(113)
    val bit113: String? = null,
    @JsonProperty("BIT_114")
    @TcpAdapterService.IsoField(114)
    val bit114: String? = null,
    @JsonProperty("BIT_115")
    @TcpAdapterService.IsoField(115)
    val bit115: String? = null,
    @JsonProperty("BIT_116")
    @TcpAdapterService.IsoField(116)
    val bit116: String? = null,
    @JsonProperty("BIT_117")
    @TcpAdapterService.IsoField(117)
    val bit117: String? = null,
    @JsonProperty("BIT_118")
    @TcpAdapterService.IsoField(118)
    val bit118: String? = null,
    @JsonProperty("BIT_119")
    @TcpAdapterService.IsoField(119)
    val bit119: String? = null,
    @JsonProperty("BIT_120")
    @TcpAdapterService.IsoField(120)
    val bit120: String? = null,
    @JsonProperty("BIT_121")
    @TcpAdapterService.IsoField(121)
    val bit121: String? = null,
    @JsonProperty("BIT_122")
    @TcpAdapterService.IsoField(122)
    val bit122: String? = null,
    @JsonProperty("BIT_123")
    @TcpAdapterService.IsoField(123)
    val bit123: String? = null,
    @JsonProperty("BIT_124")
    @TcpAdapterService.IsoField(124)
    val bit124: String? = null,
    @JsonProperty("BIT_125")
    @TcpAdapterService.IsoField(125)
    val bit125: String? = null,
    @JsonProperty("BIT_126")
    @TcpAdapterService.IsoField(126)
    val bit126: String? = null,
    @JsonProperty("BIT_127")
    @TcpAdapterService.IsoField(127)
    val bit127: String? = null,
    @JsonProperty("BIT_128")
    @TcpAdapterService.IsoField(128)
    val bit128: String? = null

)
