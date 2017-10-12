package com.ali.jadom.dom;

import com.ali.jadom.dom.superelements.DOMobject;

public enum CharsetEnum implements DOMobject{
	US_ASCII{
		@Override
		public String toString() {
			return  "US-ASCII";
		}
	},
	ISO_8859_1{
		@Override
		public String toString() {
			return  "ISO-8859-1";
		}
	},
	ISO_8859_2{
		@Override
		public String toString() {
			return  "ISO-8859-2";
		}
	},
	ISO_8859_3{
		@Override
		public String toString() {
			return  "ISO-8859-3";
		}
	},
	ISO_8859_4{
		@Override
		public String toString() {
			return  "ISO-8859-4";
		}
	},
	ISO_8859_5{
		@Override
		public String toString() {
			return  "ISO-8859-5";
		}
	},
	ISO_8859_61{
		@Override
		public String toString() {
			return  "ISO-8859-6";
		}
	},
	ISO_8859_7{
		@Override
		public String toString() {
			return  "ISO-8859-7";
		}
	},
	ISO_8859_8{
		@Override
		public String toString() {
			return  "ISO-8859-8";
		}
	},
	ISO_8859_9{
		@Override
		public String toString() {
			return  "ISO-8859-9";
		}
	},
	ISO_8859_10{
		@Override
		public String toString() {
			return  "ISO-8859-10";
		}
	},
	Shift_JIS,
	EUC_JP {
		@Override
		public String toString() {
			return  "EUC-JP";
		}
	},
	ISO_2022_KR{
		@Override
		public String toString() {
			return  "ISO-2022-KR";
		} 
	},
	EUC_KR{
		@Override
		public String toString() {
			return  "EUC-KR";
		} 
	},
	ISO_2022_JP{
		@Override
		public String toString() {
			return  "ISO-2022-JP";
		} 
	},
	ISO_2022_JP2{
		@Override
		public String toString() {
			return  "ISO-2022-JP2";
		} 
	},
	ISO_8859_6_E{
		@Override
		public String toString() {
			return  "ISO-8859-6-E";
		} 
	},
	ISO_8859_6_I{
		@Override
		public String toString() {
			return  "ISO-8859-6-I";
		} 
	},
	ISO_8859_8_E{
		@Override
		public String toString() {
			return  "ISO-8859-8-E";
		} 
	},
	ISO_8859_8_I{
		@Override
		public String toString() {
			return  "ISO-8859-8-I";
		} 
	},
	GB2312,
	Big5,
	KOI8_R{
		@Override
		public String toString() {
			return  "KOI8-R";
		} 
	} 
}
