<template>
	<view class="container">
		<view class="top">
			<view class="top-left">
				<view class="top-left-box">
					<view class="box" v-show="!recommend"><navigator @tap="clickshow()">关注</navigator></view>
					<view class="box navigator" v-show="recommend"><navigator>关注</navigator></view>
				</view>
				<view class="top-left-box">
					<view class="box" v-show="!special"><navigator @tap="clickshow2()">简友圈</navigator></view>
					<view class="box navigator" v-show="special"><navigator>简友圈</navigator></view>
				</view>
				<view class="top-left-box">
					<view class="box" v-show="!serialize"><navigator @tap="clickshow3()">专题</navigator></view>
					<view class="box navigator" v-show="serialize"><navigator>专题</navigator></view>
				</view>
				<view class="top-left-box">
					<view class="box" v-show="!four"><navigator @tap="clickshow4()">作者</navigator></view>
					<view class="box navigator" v-show="four"><navigator>作者</navigator></view>
				</view>
			</view>
			<view class="top-right" >
				<view class="search">
					<navigator url="../search/search"><image src="../../static/gengduo.png"></image></navigator>
				</view>
			</view>
		</view>
		<view class="content" >
					<view class="list">
						<view class="list-item" v-for="(follow, index) in follows" :key="index" v-show="recommend">
							<image :src="follow.avatar" class="avatar_small"></image>
							<text class="text">{{follow.nickname}}</text>
						</view>
					</view>
				</view>
	</view>
</template>

<script>
export default{
	data(){
		return{
		recommend: true,
		special: false,
		serialize: false,
		four:false,
		five:false,
		follows:[],
		articles:[]
		};
		},
	onShow: function() {
		var _this = this;
		const loginKey = uni.getStorageSync('login_key');

		if (loginKey) {
			this.storageData = {
				login: loginKey.login,
				nickname: loginKey.nickname,
				avatar: loginKey.avatar,
				userId: loginKey.userId
			};
			uni.request({
				url: this.apiServer + '/article/user',
				method: 'GET',
				header: { 'content-type': 'application/x-www-form-urlencoded' },
				data: {
					userId: this.storageData.userId
				},
				success: res => {
					_this.articles = res.data.data;
				}
			});
			uni.request({
				url: this.apiServer + '/follow/list',
				method: 'GET',
				header: { 'content-type': 'application/x-www-form-urlencoded' },
				data: {
					fromUId: this.storageData.userId
				},
				success: res => {
					_this.follows = res.data.data;
				}
			});
		} else {
			this.storageData = {
				login: false
			};
		}

		uni.request({
			url: 'http://localhost:8080/api/user/' + uni.getStorageSync('login_key').userId,
			method: 'GET',
			header: { 'content-type': 'application/json' },
			success: res => {
				if (res.data.code === 0) {
					console.log(res.data.data.avatar + '————————————');
					_this.avatar = res.data.data.avatar;
					_this.nickname = res.data.data.nickname;
				}
			}
		});
	},

		methods:{
			clickshow: function() {
				this.recommend = true;
				this.special = false;
				this.serialize = false;
				this.four = false;
			},
			clickshow2: function() {
				this.recommend = false;
				this.special = true;
				this.serialize = false;
				this.four = false;
			},
			clickshow3: function() {
				this.recommend = false;
				this.special = false;
				this.serialize = true;
				this.four = false;
			},
				clickshow4: function() {
				this.recommend = false;
				this.special = false;
				this.serialize = false;
				this.four = true;
				
			},
			
		}
		
}

</script>

<style>
	.content{
		
	}
.avatar_small{
		width: 50px;
		height: 50px;
		border-radius: 50%;
	}
	.text{
		margin-left: 20px;
		
	}
.list{
	margin-top: 20px;
}
.list-item{
	margin-bottom: 40px;
    height: 70px;
	
}
.top {
	width: 100%;
	height: 35px;
	background: #ffffff;
	display: flex;
	justify-content: space-between;
	
	margin-top: 15px;
	
}
.top-left {
	
	margin-left: 3px;
	display: flex;
	width: 100%;
}
.top-left-box {
	height: 100%;
	display: flex;
	flex: 1 1 30%;
}
.top-right {
	margin-right: 10px;
}
.navigator {
	color: #fd572b;
	border-bottom: 2px solid #fd572b;
}
.search image {
	width: 25px;
	height: 25px;
}

</style>

