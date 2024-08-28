
var HashMap = function () {
    let map = {};
    return {
        put: function (key, value) {
            map[key] = value;
        },
        keys: function () {
            return Object.keys(map);
        },
        contains: function (key) {
            return map.hasOwnProperty(key);
        },
        get: function (key) {
            return map[key];
        },
        clear: function () {
            return map = {};
        }
    };
};