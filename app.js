var express = require('express');
var app = express();
var mongoose = require('mongoose');
var bodyParser = require('body-parser');    // pull information from HTML POST (express4)
app.use(bodyParser.urlencoded({'extended':'true'}));            // parse application/x-www-form-urlencoded
app.use(bodyParser.json());                                     // parse applicaetion/json
app.use(bodyParser.json({ type: 'application/vnd.api+json' })); // parse application/vnd.api+json as json

app.use(express.static(__dirname + '/public'));
app.use( express.static( "public" ) );

mongoose.connect('mongodb://137.110.91.32:27017'); //establishing connection to the MongoDB Database currently running on ucsd server

// models ===============================================

var Chore = mongoose.model('Chore', {
	name: String,
	value: Number
});

var Child = mongoose.model('Child', {
	username: String,
	wishList: {
			itemName: String,
			price: Number,
			balance: Number
		},
	chores: [
		{
			name: String,
			value: Number,
			status: String
		}
	]
});

var Parent = mongoose.model('Parent', { 
	username: String,
	childId: mongoose.Schema.Types.ObjectId
		
});

// routes ===============================================

// Child
app.post('/api/child/addChild', function(req, res) {
	var username = req.body.username;
	Child.create({
		username : username
	}, function(err, child) {
		if (err)
			res.send(err);

		Child.findOne({"username": username},function(err, child) {
			if (err)
				res.send(err)
			res.json(child);
		});
	});
});


app.post('/api/child/addItem', function (req, res) {
	Child.where({ "username": "Bobby" }).update({"wishList": req.body}, function(err, child) {
		if (err)
			res.send(err);
		res.send(200);
	});
});

app.get('/api/child/getChores', function (req, res) {
	Child.findOne({"username": "Bobby"},function(err, child) {
		if (err)
			res.send(err);
		res.json(child.chores);
	});
});

app.post('/api/child/checkOffChores', function (req, res) {
	console.log(req.body);

	Child.where({ "username": "Bobby" }).update({"chores": req.body}, function(err, child) {
		if (err)
			res.send(err);
		res.send(200);
	});
});

app.get('/api/child/getBalance', function (req, res) {
	Child.findOne({"username": "Bobby"},function(err, child) {
		if (err)
			res.send(err);
		res.json(child.balance);
	});
});

app.post('/api/child/updateBalance', function (req, res) {
	console.log(req.body);

	Child.where({ "username": "Bobby" }).update({"balance": req.body}, function(err, child) {
		if (err)
			res.send(err);
		res.send(200);
	});
});

// Parent

app.post('/api/parent/addParent', function(req, res) {
	var username = req.body.username;
	Parent.create({
		username : username
	}, function(err, parent) {
		if (err)
			res.send(err);
		Parent.findOne({"username": username},function(err, parent) {
			if (err)
				res.send(err)
			res.json(parent);
		});
	});
});


app.post('/api/parent/setChores', function (req, res) {
	console.log(req.body);

	Child.where({ "username": "Bobby" }).update({"chores": req.body}, function(err, child) {
		if (err)
			res.send(err);
		res.send(200);
	});
});

app.get('/api/parent/getChores', function (req, res) {
	Chore.find(function(err, chores) {
		if (err)
			res.send(err);
		res.json(chores);
	});
});

app.get('/api/parent/getCheckedOffChores', function (req, res) {
	Child.findOne({ "username": "Bobby" },function(err, child) {
		if (err)
			res.send(err);
		var chores = [];
		for(chore in child.chores)
		{
			if(chore.status === 'IN_PROGRESS')
			chores.push(chore); 
		}
		res.json(chores);
	});
});


app.get('/', function (req, res) {
	Child.find(function(err, child) {
		if (err)
			res.send(err)
		res.json(child);
	});

	console.log("NO CALL");
})

var server = app.listen(3000, function () {

  var host = server.address().address
  var port = server.address().port

  console.log('Example app listening at http://%s:%s', host, port)

})