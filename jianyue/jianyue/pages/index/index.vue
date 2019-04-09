<template>
	<view class="content">
		<view class="search-box">
			<view class="search-text">
				<input type="text" class="search" placeholder="搜索" v-model="searchstr" />
			</view>
			<view class="search-icon">
				<image src="../../static/search-grey.png" @tap="search()"></image>
			</view>
		</view>
		<view class="top">
			<view class="box" v-show="!showall">
				<navigator @tap="clickshow()">全部</navigator>
			</view>
			<view class="box navigator" v-show="showall">
				<navigator>全部</navigator>
			</view>
			<view class="box" v-show="!showview">
				<navigator @tap="clickshow1()">春意盎然</navigator>
			</view>
			<view class="box navigator" v-show="showview">
				<navigator>春意盎然</navigator>
			</view>
			<view class="box" v-show="!showtravel">
				<navigator @tap="clickshow2()">鸟语花香</navigator>
			</view>
			<view class="box navigator" v-show="showtravel">
				<navigator>鸟语花香</navigator>
			</view>
			<view class="box" v-show="!showflowerworld">
				<navigator @tap="clickshow3()">风景</navigator>
			</view>
			<view class="box navigator" v-show="showflowerworld">
				<navigator>风景</navigator>
			</view>
		</view>
		<hr />
		<view class="msg-content" v-for="(msg,index) in msgs" :key=index v-show="showall">
			<navigator class="msg-tile"url="../my/my">{{msg.title}}</view>
			<view class="pic-box">
				<view class="msgpic">
					<image :src="msg.msgpic1"></image>
				</view>
				<view class="msgpic">
					<image :src="msg.msgpic2"></image>
				</view>
				<view class="msgpic">
					<image :src="msg.msgpic3"></image>
				</view>
			</view>
		</view>
		<view class="msg-content" v-for="msg in filterArticles" v-show="result">
			<view class="msg-tile">{{msg.title}}</view>
			<view class="pic-box">
				<view class="msgpic">
					<image :src="msg.msgpic1"></image>
				</view>
				<view class="msgpic">
					<image :src="msg.msgpic2"></image>
				</view>
				<view class="msgpic">
					<image :src="msg.msgpic3"></image>
				</view>
			</view>
		</view>
		<navigator class="writemsg" url="../write/write" open-type="navigate">+</navigator>
		<view class="msg-content" v-show="showview">
			<view class="msg-tile">{{msgs[1].title}}</view>
			<view class="pic-box">
				<view class="msgpic">
					<image :src="msgs[1].msgpic1"></image>
				</view>
				<view class="msgpic">
					<image :src="msgs[1].msgpic2"></image>
				</view>
				<view class="msgpic">
					<image :src="msgs[1].msgpic3"></image>
				</view>
			</view>
		</view>
		<view class="msg-content" v-show="showtravel">
			<view class="msg-tile">{{msgs[0].title}}</view>
			<view class="pic-box">
				<view class="msgpic">
					<image :src="msgs[0].msgpic1"></image>
				</view>
				<view class="msgpic">
					<image :src="msgs[0].msgpic2"></image>
				</view>
				<view class="msgpic">
					<image :src="msgs[0].msgpic3"></image>
				</view>
			</view>
		</view>
		<view class="msg-content" v-show="showflowerworld">
			<view class="msg-tile">{{msgs[2].title}}</view>
			<view class="pic-box">
				<view class="msgpic">
					<image :src="msgs[2].msgpic1"></image>
				</view>
				<view class="msgpic">
					<image :src="msgs[2].msgpic2"></image>
				</view>
				<view class="msgpic">
					<image :src="msgs[2].msgpic3"></image>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				messages: [{
					title: ''
				}],
				msgs: [{
						title: '第一篇文章',
						msgpic1: '../../static/picture-1-1.jpg',
						msgpic2: '../../static/picture-1-2.jpg',
						msgpic3: '../../static/picture-1-3.jpg',
					},
					{
						title: '第二篇文章',
						msgpic1: '../../static/picture-2-1.jpg',
						msgpic2: '../../static/picture-2-2.jpg',
						msgpic3: '../../static/picture-2-3.jpg',
					},
					{
						title: '第三篇文章',
						msgpic1: '../../static/picture-3-1.jpg',
						msgpic2: '../../static/picture-3-2.jpg',
						msgpic3: '../../static/picture-3-3.jpg',
					},
					{
						title: '第四篇文章',
						msgpic1: '../../static/picture-4-1.jpg',
						msgpic2: '../../static/picture-4-2.jpg',
						msgpic3: '../../static/picture-4-3.jpg',
					}
				],
				showall: true,
				showview: false,
				showtravel: false,
				showflowerworld: false,
				searchstr: '',
				result: false
			}
		},
		onLoad() {

		},
		methods: {
			clickshow: function() {
				this.showall = true;
				this.showview = false;
				this.showtravel = false;
				this.showflowerworld = false;
			},
			search: function() {
				this.showall = false;
				this.result = true;
			},
			clickshow1: function() {
				this.showall = false;
				this.showview = true;
				this.showtravel = false;
				this.showflowerworld = false;
			},
			clickshow2: function() {
				this.showall = false;
				this.showview = false;
				this.showtravel = true;
				this.showflowerworld = false;
			},
			clickshow3: function() {
				this.showall = false;
				this.showview = false;
				this.showtravel = false;
				this.showflowerworld = true;
			}
		},
		computed: {
			filterArticles: function() {
				var filterArray = this.msgs;
				var searchString = this.searchstr;
				//若搜索关键字为空则返回原始数据
				if (!searchString) {
					return filterArray;
				} else {
					//去除无用字符转换成小写
					searchString = searchString.trim().toLowerCase();
					//过滤数组内容
					filterArray = filterArray.filter(function(item) {
						//找到了标题含有searchString
						if (item.title.toLowerCase().indexOf(searchString) != -1) {
							return item;
						}
					})
					//最终的过滤数组
					return filterArray;
				}
			}
		}
	}
</script>

<style>
	.top {
		display: flex;
		width: 100%;
		height: 120upx;
	}

	.box {
		flex: 1 1 25%;
		display: flex;
		justify-content: center;
		align-items: center;
		border-bottom: 1px solid #EEEEEE;
	}

	.msg-content {
		padding-top: 15px;
		border-top: 1px solid #EEEEEE;
		border-bottom: 1px solid #EEEEEE;
		height: 300upx;
		width: 96%;
		margin: 0 auto;
		display: flex;
		flex-direction: column;
	}

	.pic-box {
		display: flex;
	}

	.msgpic {
		flex: 1 1 33.33%;
		height: 180upx;
	}

	.msgpic image {
		width: 230upx;
		height: 100%;
	}

	.msg-tile {
		margin-bottom: 10upx;
	}

	.navigator {
		color: #fd572b;
		border-bottom: 5upx solid #FD572B;
	}

	.writemsg {
		width: 100upx;
		height: 100upx;
		right: 25upx;
		bottom: 130upx;
		border-radius: 50%;
		background: linear-gradient(40deg, #ffd86f, #fc6262);
		box-shadow: 5px 5px 10px #AAA;
		font-size: 60upx;
		color: #FFFFFF;
		position: fixed;
		display: flex;
		align-items: center;
		justify-content: center;
	}

	.search-box {
		position: relative;
		top: 25upx;
		display: flex;
		width: 90%;
		margin: 0 auto;
		background-color: #EEEEEE;
		border-radius: 40upx;
	}

	.search-text {
		flex: 1 1 90%;
		margin-left: 30upx;
		display: flex;
		align-items: center;
	}

	.search-icon {
		margin-right: 30upx;
		flex: 1 1 5%;
		display: flex;
		align-items: center;
	}

	.search-icon image {
		width: 60upx;
		height: 60upx;
	}
</style>
