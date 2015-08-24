/*
 * angular-ui-bootstrap
 * http://angular-ui.github.io/bootstrap/

 * Version: 0.13.3 - 2015-08-09
 * License: MIT
 */
angular.module("ui.bootstrap", ["ui.bootstrap.tpls", "ui.bootstrap.collapse", "ui.bootstrap.accordion", "ui.bootstrap.alert", "ui.bootstrap.bindHtml", "ui.bootstrap.buttons", "ui.bootstrap.carousel", "ui.bootstrap.dateparser", "ui.bootstrap.position", "ui.bootstrap.datepicker", "ui.bootstrap.dropdown", "ui.bootstrap.modal", "ui.bootstrap.pagination", "ui.bootstrap.tooltip", "ui.bootstrap.popover", "ui.bootstrap.progressbar", "ui.bootstrap.rating", "ui.bootstrap.tabs", "ui.bootstrap.timepicker", "ui.bootstrap.transition", "ui.bootstrap.typeahead"]), angular.module("ui.bootstrap.tpls", ["template/accordion/accordion-group.html", "template/accordion/accordion.html", "template/alert/alert.html", "template/carousel/carousel.html", "template/carousel/slide.html", "template/datepicker/datepicker.html", "template/datepicker/day.html", "template/datepicker/month.html", "template/datepicker/popup.html", "template/datepicker/year.html", "template/modal/backdrop.html", "template/modal/window.html", "template/pagination/pager.html", "template/pagination/pagination.html", "template/tooltip/tooltip-html-popup.html", "template/tooltip/tooltip-html-unsafe-popup.html", "template/tooltip/tooltip-popup.html", "template/tooltip/tooltip-template-popup.html", "template/popover/popover-html.html", "template/popover/popover-template.html", "template/popover/popover.html", "template/progressbar/bar.html", "template/progressbar/progress.html", "template/progressbar/progressbar.html", "template/rating/rating.html", "template/tabs/tab.html", "template/tabs/tabset.html", "template/timepicker/timepicker.html", "template/typeahead/typeahead-match.html", "template/typeahead/typeahead-popup.html"]), angular.module("ui.bootstrap.collapse", []).directive("collapse", ["$animate", function (a) {
    return {
        link: function (b, c, d) {
            function e() {
                c.removeClass("collapse").addClass("collapsing").attr("aria-expanded", !0).attr("aria-hidden", !1), a.addClass(c, "in", {
                    to: {
                        height: c[0].scrollHeight + "px"
                    }
                }).then(f)
            }

            function f() {
                c.removeClass("collapsing"), c.css({
                    height: "auto"
                })
            }

            function g() {
                return c.hasClass("collapse") || c.hasClass("in") ? (c.css({
                    height: c[0].scrollHeight + "px"
                }).removeClass("collapse").addClass("collapsing").attr("aria-expanded", !1).attr("aria-hidden", !0), void a.removeClass(c, "in", {
                    to: {
                        height: "0"
                    }
                }).then(h)) : h()
            }

            function h() {
                c.css({
                    height: "0"
                }), c.removeClass("collapsing"), c.addClass("collapse")
            }
            b.$watch(d.collapse, function (a) {
                a ? g() : e()
            })
        }
    }
}]), angular.module("ui.bootstrap.accordion", ["ui.bootstrap.collapse"]).constant("accordionConfig", {
    closeOthers: !0
}).controller("AccordionController", ["$scope", "$attrs", "accordionConfig", function (a, b, c) {
    this.groups = [], this.closeOthers = function (d) {
        var e = angular.isDefined(b.closeOthers) ? a.$eval(b.closeOthers) : c.closeOthers;
        e && angular.forEach(this.groups, function (a) {
            a !== d && (a.isOpen = !1)
        })
    }, this.addGroup = function (a) {
        var b = this;
        this.groups.push(a), a.$on("$destroy", function () {
            b.removeGroup(a)
        })
    }, this.removeGroup = function (a) {
        var b = this.groups.indexOf(a); - 1 !== b && this.groups.splice(b, 1)
    }
}]).directive("accordion", function () {
    return {
        restrict: "EA",
        controller: "AccordionController",
        controllerAs: "accordion",
        transclude: !0,
        replace: !1,
        templateUrl: function (a, b) {
            return b.templateUrl || "template/accordion/accordion.html"
        }
    }
}).directive("accordionGroup", function () {
    return {
        require: "^accordion",
        restrict: "EA",
        transclude: !0,
        replace: !0,
        templateUrl: function (a, b) {
            return b.templateUrl || "template/accordion/accordion-group.html"
        },
        scope: {
            heading: "@",
            isOpen: "=?",
            isDisabled: "=?"
        },
        controller: function () {
            this.setHeading = function (a) {
                this.heading = a
            }
        },
        link: function (a, b, c, d) {
            d.addGroup(a), a.$watch("isOpen", function (b) {
                b && d.closeOthers(a)
            }), a.toggleOpen = function () {
                a.isDisabled || (a.isOpen = !a.isOpen)
            }
        }
    }
}).directive("accordionHeading", function () {
    return {
        restrict: "EA",
        transclude: !0,
        template: "",
        replace: !0,
        require: "^accordionGroup",
        link: function (a, b, c, d, e) {
            d.setHeading(e(a, angular.noop))
        }
    }
}).directive("accordionTransclude", function () {
    return {
        require: "^accordionGroup",
        link: function (a, b, c, d) {
            a.$watch(function () {
                return d[c.accordionTransclude]
            }, function (a) {
                a && (b.find("span").html(""), b.find("span").append(a))
            })
        }
    }
}), angular.module("ui.bootstrap.alert", []).controller("AlertController", ["$scope", "$attrs", function (a, b) {
    a.closeable = !!b.close, this.close = a.close
}]).directive("alert", function () {
    return {
        restrict: "EA",
        controller: "AlertController",
        controllerAs: "alert",
        templateUrl: function (a, b) {
            return b.templateUrl || "template/alert/alert.html"
        },
        transclude: !0,
        replace: !0,
        scope: {
            type: "@",
            close: "&"
        }
    }
}).directive("dismissOnTimeout", ["$timeout", function (a) {
    return {
        require: "alert",
        link: function (b, c, d, e) {
            a(function () {
                e.close()
            }, parseInt(d.dismissOnTimeout, 10))
        }
    }
}]), angular.module("ui.bootstrap.bindHtml", []).value("$bindHtmlUnsafeSuppressDeprecated", !1).directive("bindHtmlUnsafe", ["$log", "$bindHtmlUnsafeSuppressDeprecated", function (a, b) {
    return function (c, d, e) {
        b || a.warn("bindHtmlUnsafe is now deprecated. Use ngBindHtml instead"), d.addClass("ng-binding").data("$binding", e.bindHtmlUnsafe), c.$watch(e.bindHtmlUnsafe, function (a) {
            d.html(a || "")
        })
    }
}]), angular.module("ui.bootstrap.buttons", []).constant("buttonConfig", {
    activeClass: "active",
    toggleEvent: "click"
}).controller("ButtonsController", ["buttonConfig", function (a) {
    this.activeClass = a.activeClass || "active", this.toggleEvent = a.toggleEvent || "click"
}]).directive("btnRadio", function () {
    return {
        require: ["btnRadio", "ngModel"],
        controller: "ButtonsController",
        controllerAs: "buttons",
        link: function (a, b, c, d) {
            var e = d[0],
                f = d[1];
            f.$render = function () {
                b.toggleClass(e.activeClass, angular.equals(f.$modelValue, a.$eval(c.btnRadio)))
            }, b.bind(e.toggleEvent, function () {
                if (!c.disabled) {
                    var d = b.hasClass(e.activeClass);
                    (!d || angular.isDefined(c.uncheckable)) && a.$apply(function () {
                        f.$setViewValue(d ? null : a.$eval(c.btnRadio)), f.$render()
                    })
                }
            })
        }
    }
}).directive("btnCheckbox", function () {
    return {
        require: ["btnCheckbox", "ngModel"],
        controller: "ButtonsController",
        controllerAs: "button",
        link: function (a, b, c, d) {
            function e() {
                return g(c.btnCheckboxTrue, !0)
            }

            function f() {
                return g(c.btnCheckboxFalse, !1)
            }

            function g(b, c) {
                var d = a.$eval(b);
                return angular.isDefined(d) ? d : c
            }
            var h = d[0],
                i = d[1];
            i.$render = function () {
                b.toggleClass(h.activeClass, angular.equals(i.$modelValue, e()))
            }, b.bind(h.toggleEvent, function () {
                c.disabled || a.$apply(function () {
                    i.$setViewValue(b.hasClass(h.activeClass) ? f() : e()), i.$render()
                })
            })
        }
    }
}), angular.module("ui.bootstrap.carousel", []).controller("CarouselController", ["$scope", "$element", "$interval", "$animate", function (a, b, c, d) {
    function e(b, c, e) {
        r || (angular.extend(b, {
            direction: e,
            active: !0
        }), angular.extend(l.currentSlide || {}, {
            direction: e,
            active: !1
        }), d.enabled() && !a.noTransition && !a.$currentTransition && b.$element && l.slides.length > 1 && (b.$element.data(p, b.direction), l.currentSlide && l.currentSlide.$element && l.currentSlide.$element.data(p, b.direction), a.$currentTransition = !0, n ? d.on("addClass", b.$element, function (b, c) {
            "close" === c && (a.$currentTransition = null, d.off("addClass", b))
        }) : b.$element.one("$animate:close", function () {
            a.$currentTransition = null
        })), l.currentSlide = b, q = c, g())
    }

    function f(a) {
        if (angular.isUndefined(m[a].index)) return m[a]; {
            var b;
            m.length
        }
        for (b = 0; b < m.length; ++b)
            if (m[b].index == a) return m[b]
    }

    function g() {
        h();
        var b = +a.interval;
        !isNaN(b) && b > 0 && (j = c(i, b))
    }

    function h() {
        j && (c.cancel(j), j = null)
    }

    function i() {
        var b = +a.interval;
        k && !isNaN(b) && b > 0 && m.length ? a.next() : a.pause()
    }
    var j, k, l = this,
        m = l.slides = a.slides = [],
        n = angular.version.minor >= 4,
        o = "uib-noTransition",
        p = "uib-slideDirection",
        q = -1;
    l.currentSlide = null;
    var r = !1;
    l.select = a.select = function (b, c) {
        var d = a.indexOfSlide(b);
        void 0 === c && (c = d > l.getCurrentIndex() ? "next" : "prev"), b && b !== l.currentSlide && !a.$currentTransition && e(b, d, c)
    }, a.$on("$destroy", function () {
        r = !0
    }), l.getCurrentIndex = function () {
        return l.currentSlide && angular.isDefined(l.currentSlide.index) ? +l.currentSlide.index : q
    }, a.indexOfSlide = function (a) {
        return angular.isDefined(a.index) ? +a.index : m.indexOf(a)
    }, a.next = function () {
        var b = (l.getCurrentIndex() + 1) % m.length;
        return 0 === b && a.noWrap() ? void a.pause() : l.select(f(b), "next")
    }, a.prev = function () {
        var b = l.getCurrentIndex() - 1 < 0 ? m.length - 1 : l.getCurrentIndex() - 1;
        return a.noWrap() && b === m.length - 1 ? void a.pause() : l.select(f(b), "prev")
    }, a.isActive = function (a) {
        return l.currentSlide === a
    }, a.$watch("interval", g), a.$on("$destroy", h), a.play = function () {
        k || (k = !0, g())
    }, a.pause = function () {
        a.noPause || (k = !1, h())
    }, l.addSlide = function (b, c) {
        b.$element = c, m.push(b), 1 === m.length || b.active ? (l.select(m[m.length - 1]), 1 == m.length && a.play()) : b.active = !1
    }, l.removeSlide = function (a) {
        angular.isDefined(a.index) && m.sort(function (a, b) {
            return +a.index > +b.index
        });
        var b = m.indexOf(a);
        m.splice(b, 1), m.length > 0 && a.active ? l.select(b >= m.length ? m[b - 1] : m[b]) : q > b && q--, 0 === m.length && (l.currentSlide = null)
    }, a.$watch("noTransition", function (a) {
        b.data(o, a)
    })
}]).directive("carousel", [function () {
    return {
        restrict: "EA",
        transclude: !0,
        replace: !0,
        controller: "CarouselController",
        controllerAs: "carousel",
        require: "carousel",
        templateUrl: function (a, b) {
            return b.templateUrl || "template/carousel/carousel.html"
        },
        scope: {
            interval: "=",
            noTransition: "=",
            noPause: "=",
            noWrap: "&"
        }
    }
}]).directive("slide", function () {
    return {
        require: "^carousel",
        restrict: "EA",
        transclude: !0,
        replace: !0,
        templateUrl: function (a, b) {
            return b.templateUrl || "template/carousel/slide.html"
        },
        scope: {
            active: "=?",
            index: "=?"
        },
        link: function (a, b, c, d) {
            d.addSlide(a, b), a.$on("$destroy", function () {
                d.removeSlide(a)
            }), a.$watch("active", function (b) {
                b && d.select(a)
            })
        }
    }
}).animation(".item", ["$injector", "$animate", function (a, b) {
    function c(a, b, c) {
        a.removeClass(b), c && c()
    }
    var d = "uib-noTransition",
        e = "uib-slideDirection",
        f = null;
    return a.has("$animateCss") && (f = a.get("$animateCss")), {
        beforeAddClass: function (a, g, h) {
            if ("active" == g && a.parent() && !a.parent().data(d)) {
                var i = !1,
                    j = a.data(e),
                    k = "next" == j ? "left" : "right",
                    l = c.bind(this, a, k + " " + j, h);
                return a.addClass(j), f ? f(a, {
                        addClass: k
                    }).start().done(l) : b.addClass(a, k).then(function () {
                        i || l(), h()
                    }),
                    function () {
                        i = !0
                    }
            }
            h()
        },
        beforeRemoveClass: function (a, g, h) {
            if ("active" === g && a.parent() && !a.parent().data(d)) {
                var i = !1,
                    j = a.data(e),
                    k = "next" == j ? "left" : "right",
                    l = c.bind(this, a, k, h);
                return f ? f(a, {
                        addClass: k
                    }).start().done(l) : b.addClass(a, k).then(function () {
                        i || l(), h()
                    }),
                    function () {
                        i = !0
                    }
            }
            h()
        }
    }
}]), angular.module("ui.bootstrap.dateparser", []).service("dateParser", ["$log", "$locale", "orderByFilter", function (a, b, c) {
    function d(a) {
        var b = [],
            d = a.split("");
        return angular.forEach(g, function (c, e) {
            var f = a.indexOf(e);
            if (f > -1) {
                a = a.split(""), d[f] = "(" + c.regex + ")", a[f] = "$";
                for (var g = f + 1, h = f + e.length; h > g; g++) d[g] = "", a[g] = "$";
                a = a.join(""), b.push({
                    index: f,
                    apply: c.apply
                })
            }
        }), {
            regex: new RegExp("^" + d.join("") + "$"),
            map: c(b, "index")
        }
    }

    function e(a, b, c) {
        return 1 > c ? !1 : 1 === b && c > 28 ? 29 === c && (a % 4 === 0 && a % 100 !== 0 || a % 400 === 0) : 3 === b || 5 === b || 8 === b || 10 === b ? 31 > c : !0
    }
    var f = /[\\\^\$\*\+\?\|\[\]\(\)\.\{\}]/g;
    this.parsers = {};
    var g = {
        yyyy: {
            regex: "\\d{4}",
            apply: function (a) {
                this.year = +a
            }
        },
        yy: {
            regex: "\\d{2}",
            apply: function (a) {
                this.year = +a + 2e3
            }
        },
        y: {
            regex: "\\d{1,4}",
            apply: function (a) {
                this.year = +a
            }
        },
        MMMM: {
            regex: b.DATETIME_FORMATS.MONTH.join("|"),
            apply: function (a) {
                this.month = b.DATETIME_FORMATS.MONTH.indexOf(a)
            }
        },
        MMM: {
            regex: b.DATETIME_FORMATS.SHORTMONTH.join("|"),
            apply: function (a) {
                this.month = b.DATETIME_FORMATS.SHORTMONTH.indexOf(a)
            }
        },
        MM: {
            regex: "0[1-9]|1[0-2]",
            apply: function (a) {
                this.month = a - 1
            }
        },
        M: {
            regex: "[1-9]|1[0-2]",
            apply: function (a) {
                this.month = a - 1
            }
        },
        dd: {
            regex: "[0-2][0-9]{1}|3[0-1]{1}",
            apply: function (a) {
                this.date = +a
            }
        },
        d: {
            regex: "[1-2]?[0-9]{1}|3[0-1]{1}",
            apply: function (a) {
                this.date = +a
            }
        },
        EEEE: {
            regex: b.DATETIME_FORMATS.DAY.join("|")
        },
        EEE: {
            regex: b.DATETIME_FORMATS.SHORTDAY.join("|")
        },
        HH: {
            regex: "(?:0|1)[0-9]|2[0-3]",
            apply: function (a) {
                this.hours = +a
            }
        },
        hh: {
            regex: "0[0-9]|1[0-2]",
            apply: function (a) {
                this.hours = +a
            }
        },
        H: {
            regex: "1?[0-9]|2[0-3]",
            apply: function (a) {
                this.hours = +a
            }
        },
        mm: {
            regex: "[0-5][0-9]",
            apply: function (a) {
                this.minutes = +a
            }
        },
        m: {
            regex: "[0-9]|[1-5][0-9]",
            apply: function (a) {
                this.minutes = +a
            }
        },
        sss: {
            regex: "[0-9][0-9][0-9]",
            apply: function (a) {
                this.milliseconds = +a
            }
        },
        ss: {
            regex: "[0-5][0-9]",
            apply: function (a) {
                this.seconds = +a
            }
        },
        s: {
            regex: "[0-9]|[1-5][0-9]",
            apply: function (a) {
                this.seconds = +a
            }
        },
        a: {
            regex: b.DATETIME_FORMATS.AMPMS.join("|"),
            apply: function (a) {
                12 === this.hours && (this.hours = 0), "PM" === a && (this.hours += 12)
            }
        }
    };
    this.parse = function (c, g, h) {
        if (!angular.isString(c) || !g) return c;
        g = b.DATETIME_FORMATS[g] || g, g = g.replace(f, "\\$&"), this.parsers[g] || (this.parsers[g] = d(g));
        var i = this.parsers[g],
            j = i.regex,
            k = i.map,
            l = c.match(j);
        if (l && l.length) {
            var m, n;
            angular.isDate(h) && !isNaN(h.getTime()) ? m = {
                year: h.getFullYear(),
                month: h.getMonth(),
                date: h.getDate(),
                hours: h.getHours(),
                minutes: h.getMinutes(),
                seconds: h.getSeconds(),
                milliseconds: h.getMilliseconds()
            } : (h && a.warn("dateparser:", "baseDate is not a valid date"), m = {
                year: 1900,
                month: 0,
                date: 1,
                hours: 0,
                minutes: 0,
                seconds: 0,
                milliseconds: 0
            });
            for (var o = 1, p = l.length; p > o; o++) {
                var q = k[o - 1];
                q.apply && q.apply.call(m, l[o])
            }
            return e(m.year, m.month, m.date) && (n = new Date(m.year, m.month, m.date, m.hours, m.minutes, m.seconds, m.milliseconds || 0)), n
        }
    }
}]), angular.module("ui.bootstrap.position", []).factory("$position", ["$document", "$window", function (a, b) {
    function c(a, c) {
        return a.currentStyle ? a.currentStyle[c] : b.getComputedStyle ? b.getComputedStyle(a)[c] : a.style[c]
    }

    function d(a) {
        return "static" === (c(a, "position") || "static")
    }
    var e = function (b) {
        for (var c = a[0], e = b.offsetParent || c; e && e !== c && d(e);) e = e.offsetParent;
        return e || c
    };
    return {
        position: function (b) {
            var c = this.offset(b),
                d = {
                    top: 0,
                    left: 0
                },
                f = e(b[0]);
            f != a[0] && (d = this.offset(angular.element(f)), d.top += f.clientTop - f.scrollTop, d.left += f.clientLeft - f.scrollLeft);
            var g = b[0].getBoundingClientRect();
            return {
                width: g.width || b.prop("offsetWidth"),
                height: g.height || b.prop("offsetHeight"),
                top: c.top - d.top,
                left: c.left - d.left
            }
        },
        offset: function (c) {
            var d = c[0].getBoundingClientRect();
            return {
                width: d.width || c.prop("offsetWidth"),
                height: d.height || c.prop("offsetHeight"),
                top: d.top + (b.pageYOffset || a[0].documentElement.scrollTop),
                left: d.left + (b.pageXOffset || a[0].documentElement.scrollLeft)
            }
        },
        positionElements: function (a, b, c, d) {
            var e, f, g, h, i = c.split("-"),
                j = i[0],
                k = i[1] || "center";
            e = d ? this.offset(a) : this.position(a), f = b.prop("offsetWidth"), g = b.prop("offsetHeight");
            var l = {
                    center: function () {
                        return e.left + e.width / 2 - f / 2
                    },
                    left: function () {
                        return e.left
                    },
                    right: function () {
                        return e.left + e.width
                    }
                },
                m = {
                    center: function () {
                        return e.top + e.height / 2 - g / 2
                    },
                    top: function () {
                        return e.top
                    },
                    bottom: function () {
                        return e.top + e.height
                    }
                };
            switch (j) {
                case "right":
                    h = {
                        top: m[k](),
                        left: l[j]()
                    };
                    break;
                case "left":
                    h = {
                        top: m[k](),
                        left: e.left - f
                    };
                    break;
                case "bottom":
                    h = {
                        top: m[j](),
                        left: l[k]()
                    };
                    break;
                default:
                    h = {
                        top: e.top - g,
                        left: l[k]()
                    }
            }
            return h
        }
    }
}]), angular.module("ui.bootstrap.datepicker", ["ui.bootstrap.dateparser", "ui.bootstrap.position"]).value("$datepickerSuppressError", !1).constant("datepickerConfig", {
    formatDay: "dd",
    formatMonth: "MMMM",
    formatYear: "yyyy",
    formatDayHeader: "EEE",
    formatDayTitle: "MMMM yyyy",
    formatMonthTitle: "yyyy",
    datepickerMode: "day",
    minMode: "day",
    maxMode: "year",
    showWeeks: !0,
    startingDay: 0,
    yearRange: 20,
    minDate: null,
    maxDate: null,
    shortcutPropagation: !1
}).controller("DatepickerController", ["$scope", "$attrs", "$parse", "$interpolate", "$log", "dateFilter", "datepickerConfig", "$datepickerSuppressError", function (a, b, c, d, e, f, g, h) {
    var i = this,
        j = {
            $setViewValue: angular.noop
        };
    this.modes = ["day", "month", "year"], angular.forEach(["formatDay", "formatMonth", "formatYear", "formatDayHeader", "formatDayTitle", "formatMonthTitle", "showWeeks", "startingDay", "yearRange", "shortcutPropagation"], function (c, e) {
        i[c] = angular.isDefined(b[c]) ? 6 > e ? d(b[c])(a.$parent) : a.$parent.$eval(b[c]) : g[c]
    }), angular.forEach(["minDate", "maxDate"], function (d) {
        b[d] ? a.$parent.$watch(c(b[d]), function (a) {
            i[d] = a ? new Date(a) : null, i.refreshView()
        }) : i[d] = g[d] ? new Date(g[d]) : null
    }), angular.forEach(["minMode", "maxMode"], function (d) {
        b[d] ? a.$parent.$watch(c(b[d]), function (c) {
            i[d] = angular.isDefined(c) ? c : b[d], a[d] = i[d], ("minMode" == d && i.modes.indexOf(a.datepickerMode) < i.modes.indexOf(i[d]) || "maxMode" == d && i.modes.indexOf(a.datepickerMode) > i.modes.indexOf(i[d])) && (a.datepickerMode = i[d])
        }) : (i[d] = g[d] || null, a[d] = i[d])
    }), a.datepickerMode = a.datepickerMode || g.datepickerMode, a.uniqueId = "datepicker-" + a.$id + "-" + Math.floor(1e4 * Math.random()), angular.isDefined(b.initDate) ? (this.activeDate = a.$parent.$eval(b.initDate) || new Date, a.$parent.$watch(b.initDate, function (a) {
        a && (j.$isEmpty(j.$modelValue) || j.$invalid) && (i.activeDate = a, i.refreshView())
    })) : this.activeDate = new Date, a.isActive = function (b) {
        return 0 === i.compare(b.date, i.activeDate) ? (a.activeDateId = b.uid, !0) : !1
    }, this.init = function (a) {
        j = a, j.$render = function () {
            i.render()
        }
    }, this.render = function () {
        if (j.$viewValue) {
            var a = new Date(j.$viewValue),
                b = !isNaN(a);
            b ? this.activeDate = a : h || e.error('Datepicker directive: "ng-model" value must be a Date object, a number of milliseconds since 01.01.1970 or a string representing an RFC2822 or ISO 8601 date.')
        }
        this.refreshView()
    }, this.refreshView = function () {
        if (this.element) {
            this._refreshView();
            var a = j.$viewValue ? new Date(j.$viewValue) : null;
            j.$setValidity("dateDisabled", !a || this.element && !this.isDisabled(a))
        }
    }, this.createDateObject = function (a, b) {
        var c = j.$viewValue ? new Date(j.$viewValue) : null;
        return {
            date: a,
            label: f(a, b),
            selected: c && 0 === this.compare(a, c),
            disabled: this.isDisabled(a),
            current: 0 === this.compare(a, new Date),
            customClass: this.customClass(a)
        }
    }, this.isDisabled = function (c) {
        return this.minDate && this.compare(c, this.minDate) < 0 || this.maxDate && this.compare(c, this.maxDate) > 0 || b.dateDisabled && a.dateDisabled({
            date: c,
            mode: a.datepickerMode
        })
    }, this.customClass = function (b) {
        return a.customClass({
            date: b,
            mode: a.datepickerMode
        })
    }, this.split = function (a, b) {
        for (var c = []; a.length > 0;) c.push(a.splice(0, b));
        return c
    }, this.fixTimeZone = function (a) {
        var b = a.getHours();
        a.setHours(23 === b ? b + 2 : 0)
    }, a.select = function (b) {
        if (a.datepickerMode === i.minMode) {
            var c = j.$viewValue ? new Date(j.$viewValue) : new Date(0, 0, 0, 0, 0, 0, 0);
            c.setFullYear(b.getFullYear(), b.getMonth(), b.getDate()), j.$setViewValue(c), j.$render()
        } else i.activeDate = b, a.datepickerMode = i.modes[i.modes.indexOf(a.datepickerMode) - 1]
    }, a.move = function (a) {
        var b = i.activeDate.getFullYear() + a * (i.step.years || 0),
            c = i.activeDate.getMonth() + a * (i.step.months || 0);
        i.activeDate.setFullYear(b, c, 1), i.refreshView()
    }, a.toggleMode = function (b) {
        b = b || 1, a.datepickerMode === i.maxMode && 1 === b || a.datepickerMode === i.minMode && -1 === b || (a.datepickerMode = i.modes[i.modes.indexOf(a.datepickerMode) + b])
    }, a.keys = {
        13: "enter",
        32: "space",
        33: "pageup",
        34: "pagedown",
        35: "end",
        36: "home",
        37: "left",
        38: "up",
        39: "right",
        40: "down"
    };
    var k = function () {
        i.element[0].focus()
    };
    a.$on("datepicker.focus", k), a.keydown = function (b) {
        var c = a.keys[b.which];
        if (c && !b.shiftKey && !b.altKey)
            if (b.preventDefault(), i.shortcutPropagation || b.stopPropagation(), "enter" === c || "space" === c) {
                if (i.isDisabled(i.activeDate)) return;
                a.select(i.activeDate), k()
            } else !b.ctrlKey || "up" !== c && "down" !== c ? (i.handleKeyDown(c, b), i.refreshView()) : (a.toggleMode("up" === c ? 1 : -1), k())
    }
}]).directive("datepicker", function () {
    return {
        restrict: "EA",
        replace: !0,
        templateUrl: function (a, b) {
            return b.templateUrl || "template/datepicker/datepicker.html"
        },
        scope: {
            datepickerMode: "=?",
            dateDisabled: "&",
            customClass: "&",
            shortcutPropagation: "&?"
        },
        require: ["datepicker", "^ngModel"],
        controller: "DatepickerController",
        controllerAs: "datepicker",
        link: function (a, b, c, d) {
            var e = d[0],
                f = d[1];
            e.init(f)
        }
    }
}).directive("daypicker", ["dateFilter", function (a) {
    return {
        restrict: "EA",
        replace: !0,
        templateUrl: "template/datepicker/day.html",
        require: "^datepicker",
        link: function (b, c, d, e) {
            function f(a, b) {
                return 1 !== b || a % 4 !== 0 || a % 100 === 0 && a % 400 !== 0 ? i[b] : 29
            }

            function g(a, b) {
                for (var c, d = new Array(b), f = new Date(a), g = 0; b > g;) c = new Date(f), e.fixTimeZone(c), d[g++] = c, f.setDate(f.getDate() + 1);
                return d
            }

            function h(a) {
                var b = new Date(a);
                b.setDate(b.getDate() + 4 - (b.getDay() || 7));
                var c = b.getTime();
                return b.setMonth(0), b.setDate(1), Math.floor(Math.round((c - b) / 864e5) / 7) + 1
            }
            b.showWeeks = e.showWeeks, e.step = {
                months: 1
            }, e.element = c;
            var i = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
            e._refreshView = function () {
                var c = e.activeDate.getFullYear(),
                    d = e.activeDate.getMonth(),
                    f = new Date(c, d, 1),
                    i = e.startingDay - f.getDay(),
                    j = i > 0 ? 7 - i : -i,
                    k = new Date(f);
                j > 0 && k.setDate(-j + 1);
                for (var l = g(k, 42), m = 0; 42 > m; m++) l[m] = angular.extend(e.createDateObject(l[m], e.formatDay), {
                    secondary: l[m].getMonth() !== d,
                    uid: b.uniqueId + "-" + m
                });
                b.labels = new Array(7);
                for (var n = 0; 7 > n; n++) b.labels[n] = {
                    abbr: a(l[n].date, e.formatDayHeader),
                    full: a(l[n].date, "EEEE")
                };
                if (b.title = a(e.activeDate, e.formatDayTitle), b.rows = e.split(l, 7), b.showWeeks) {
                    b.weekNumbers = [];
                    for (var o = (11 - e.startingDay) % 7, p = b.rows.length, q = 0; p > q; q++) b.weekNumbers.push(h(b.rows[q][o].date))
                }
            }, e.compare = function (a, b) {
                return new Date(a.getFullYear(), a.getMonth(), a.getDate()) - new Date(b.getFullYear(), b.getMonth(), b.getDate())
            }, e.handleKeyDown = function (a) {
                var b = e.activeDate.getDate();
                if ("left" === a) b -= 1;
                else if ("up" === a) b -= 7;
                else if ("right" === a) b += 1;
                else if ("down" === a) b += 7;
                else if ("pageup" === a || "pagedown" === a) {
                    var c = e.activeDate.getMonth() + ("pageup" === a ? -1 : 1);
                    e.activeDate.setMonth(c, 1), b = Math.min(f(e.activeDate.getFullYear(), e.activeDate.getMonth()), b)
                } else "home" === a ? b = 1 : "end" === a && (b = f(e.activeDate.getFullYear(), e.activeDate.getMonth()));
                e.activeDate.setDate(b)
            }, e.refreshView()
        }
    }
}]).directive("monthpicker", ["dateFilter", function (a) {
    return {
        restrict: "EA",
        replace: !0,
        templateUrl: "template/datepicker/month.html",
        require: "^datepicker",
        link: function (b, c, d, e) {
            e.step = {
                years: 1
            }, e.element = c, e._refreshView = function () {
                for (var c, d = new Array(12), f = e.activeDate.getFullYear(), g = 0; 12 > g; g++) c = new Date(f, g, 1), e.fixTimeZone(c), d[g] = angular.extend(e.createDateObject(c, e.formatMonth), {
                    uid: b.uniqueId + "-" + g
                });
                b.title = a(e.activeDate, e.formatMonthTitle), b.rows = e.split(d, 3)
            }, e.compare = function (a, b) {
                return new Date(a.getFullYear(), a.getMonth()) - new Date(b.getFullYear(), b.getMonth())
            }, e.handleKeyDown = function (a) {
                var b = e.activeDate.getMonth();
                if ("left" === a) b -= 1;
                else if ("up" === a) b -= 3;
                else if ("right" === a) b += 1;
                else if ("down" === a) b += 3;
                else if ("pageup" === a || "pagedown" === a) {
                    var c = e.activeDate.getFullYear() + ("pageup" === a ? -1 : 1);
                    e.activeDate.setFullYear(c)
                } else "home" === a ? b = 0 : "end" === a && (b = 11);
                e.activeDate.setMonth(b)
            }, e.refreshView()
        }
    }
}]).directive("yearpicker", ["dateFilter", function () {
    return {
        restrict: "EA",
        replace: !0,
        templateUrl: "template/datepicker/year.html",
        require: "^datepicker",
        link: function (a, b, c, d) {
            function e(a) {
                return parseInt((a - 1) / f, 10) * f + 1
            }
            var f = d.yearRange;
            d.step = {
                years: f
            }, d.element = b, d._refreshView = function () {
                for (var b, c = new Array(f), g = 0, h = e(d.activeDate.getFullYear()); f > g; g++) b = new Date(h + g, 0, 1), d.fixTimeZone(b), c[g] = angular.extend(d.createDateObject(b, d.formatYear), {
                    uid: a.uniqueId + "-" + g
                });
                a.title = [c[0].label, c[f - 1].label].join(" - "), a.rows = d.split(c, 5)
            }, d.compare = function (a, b) {
                return a.getFullYear() - b.getFullYear()
            }, d.handleKeyDown = function (a) {
                var b = d.activeDate.getFullYear();
                "left" === a ? b -= 1 : "up" === a ? b -= 5 : "right" === a ? b += 1 : "down" === a ? b += 5 : "pageup" === a || "pagedown" === a ? b += ("pageup" === a ? -1 : 1) * d.step.years : "home" === a ? b = e(d.activeDate.getFullYear()) : "end" === a && (b = e(d.activeDate.getFullYear()) + f - 1), d.activeDate.setFullYear(b)
            }, d.refreshView()
        }
    }
}]).constant("datepickerPopupConfig", {
    datepickerPopup: "yyyy-MM-dd",
    datepickerPopupTemplateUrl: "template/datepicker/popup.html",
    datepickerTemplateUrl: "template/datepicker/datepicker.html",
    html5Types: {
        date: "yyyy-MM-dd",
        "datetime-local": "yyyy-MM-ddTHH:mm:ss.sss",
        month: "yyyy-MM"
    },
    currentText: "Today",
    clearText: "Clear",
    closeText: "Done",
    closeOnDateSelection: !0,
    appendToBody: !1,
    showButtonBar: !0,
    onOpenFocus: !0
}).directive("datepickerPopup", ["$compile", "$parse", "$document", "$rootScope", "$position", "dateFilter", "dateParser", "datepickerPopupConfig", "$timeout", function (a, b, c, d, e, f, g, h, i) {
    return {
        restrict: "EA",
        require: "ngModel",
        scope: {
            isOpen: "=?",
            currentText: "@",
            clearText: "@",
            closeText: "@",
            dateDisabled: "&",
            customClass: "&"
        },
        link: function (j, k, l, m) {
            function n(a) {
                return a.replace(/([A-Z])/g, function (a) {
                    return "-" + a.toLowerCase()
                })
            }

            function o(a) {
                if (angular.isNumber(a) && (a = new Date(a)), a) {
                    if (angular.isDate(a) && !isNaN(a)) return a;
                    if (angular.isString(a)) {
                        var b = g.parse(a, q, j.date);
                        return isNaN(b) ? void 0 : b
                    }
                    return void 0
                }
                return null
            }

            function p(a, b) {
                var c = a || b;
                if (!l.ngRequired && !c) return !0;
                if (angular.isNumber(c) && (c = new Date(c)), c) {
                    if (angular.isDate(c) && !isNaN(c)) return !0;
                    if (angular.isString(c)) {
                        var d = g.parse(c, q);
                        return !isNaN(d)
                    }
                    return !1
                }
                return !0
            }
            var q, r = angular.isDefined(l.closeOnDateSelection) ? j.$parent.$eval(l.closeOnDateSelection) : h.closeOnDateSelection,
                s = angular.isDefined(l.datepickerAppendToBody) ? j.$parent.$eval(l.datepickerAppendToBody) : h.appendToBody,
                t = angular.isDefined(l.onOpenFocus) ? j.$parent.$eval(l.onOpenFocus) : h.onOpenFocus,
                u = angular.isDefined(l.datepickerPopupTemplateUrl) ? l.datepickerPopupTemplateUrl : h.datepickerPopupTemplateUrl,
                v = angular.isDefined(l.datepickerTemplateUrl) ? l.datepickerTemplateUrl : h.datepickerTemplateUrl;
            j.showButtonBar = angular.isDefined(l.showButtonBar) ? j.$parent.$eval(l.showButtonBar) : h.showButtonBar, j.getText = function (a) {
                return j[a + "Text"] || h[a + "Text"]
            };
            var w = !1;
            if (h.html5Types[l.type] ? (q = h.html5Types[l.type], w = !0) : (q = l.datepickerPopup || h.datepickerPopup, l.$observe("datepickerPopup", function (a) {
                    var b = a || h.datepickerPopup;
                    if (b !== q && (q = b, m.$modelValue = null, !q)) throw new Error("datepickerPopup must have a date format specified.")
                })), !q) throw new Error("datepickerPopup must have a date format specified.");
            if (w && l.datepickerPopup) throw new Error("HTML5 date input types do not support custom formats.");
            var x = angular.element("<div datepicker-popup-wrap><div datepicker></div></div>");
            x.attr({
                "ng-model": "date",
                "ng-change": "dateSelection(date)",
                "template-url": u
            });
            var y = angular.element(x.children()[0]);
            if (y.attr("template-url", v), w && "month" == l.type && (y.attr("datepicker-mode", '"month"'), y.attr("min-mode", "month")), l.datepickerOptions) {
                var z = j.$parent.$eval(l.datepickerOptions);
                z && z.initDate && (j.initDate = z.initDate, y.attr("init-date", "initDate"), delete z.initDate), angular.forEach(z, function (a, b) {
                    y.attr(n(b), a)
                })
            }
            j.watchData = {}, angular.forEach(["minMode", "maxMode", "minDate", "maxDate", "datepickerMode", "initDate", "shortcutPropagation"], function (a) {
                if (l[a]) {
                    var c = b(l[a]);
                    if (j.$parent.$watch(c, function (b) {
                            j.watchData[a] = b
                        }), y.attr(n(a), "watchData." + a), "datepickerMode" === a) {
                        var d = c.assign;
                        j.$watch("watchData." + a, function (a, b) {
                            angular.isFunction(d) && a !== b && d(j.$parent, a)
                        })
                    }
                }
            }), l.dateDisabled && y.attr("date-disabled", "dateDisabled({ date: date, mode: mode })"), l.showWeeks && y.attr("show-weeks", l.showWeeks), l.customClass && y.attr("custom-class", "customClass({ date: date, mode: mode })"), w ? m.$formatters.push(function (a) {
                return j.date = a, a
            }) : (m.$$parserName = "date", m.$validators.date = p, m.$parsers.unshift(o), m.$formatters.push(function (a) {
                return j.date = a, m.$isEmpty(a) ? a : f(a, q)
            })), j.dateSelection = function (a) {
                angular.isDefined(a) && (j.date = a);
                var b = j.date ? f(j.date, q) : null;
                k.val(b), m.$setViewValue(b), r && (j.isOpen = !1, k[0].focus())
            }, m.$viewChangeListeners.push(function () {
                j.date = g.parse(m.$viewValue, q, j.date)
            });
            var A = function (a) {
                    j.isOpen && !k[0].contains(a.target) && j.$apply(function () {
                        j.isOpen = !1
                    })
                },
                B = function (a) {
                    27 === a.which && j.isOpen ? (a.preventDefault(), a.stopPropagation(), j.$apply(function () {
                        j.isOpen = !1
                    }), k[0].focus()) : 40 !== a.which || j.isOpen || (a.preventDefault(), a.stopPropagation(), j.$apply(function () {
                        j.isOpen = !0
                    }))
                };
            k.bind("keydown", B), j.keydown = function (a) {
                27 === a.which && (j.isOpen = !1, k[0].focus())
            }, j.$watch("isOpen", function (a) {
                a ? (j.position = s ? e.offset(k) : e.position(k), j.position.top = j.position.top + k.prop("offsetHeight"), i(function () {
                    t && j.$broadcast("datepicker.focus"), c.bind("click", A)
                }, 0, !1)) : c.unbind("click", A)
            }), j.select = function (a) {
                if ("today" === a) {
                    var b = new Date;
                    angular.isDate(j.date) ? (a = new Date(j.date), a.setFullYear(b.getFullYear(), b.getMonth(), b.getDate())) : a = new Date(b.setHours(0, 0, 0, 0))
                }
                j.dateSelection(a)
            }, j.close = function () {
                j.isOpen = !1, k[0].focus()
            };
            var C = a(x)(j);
            x.remove(), s ? c.find("body").append(C) : k.after(C), j.$on("$destroy", function () {
                j.isOpen === !0 && (d.$$phase || j.$apply(function () {
                    j.isOpen = !1
                })), C.remove(), k.unbind("keydown", B), c.unbind("click", A)
            })
        }
    }
}]).directive("datepickerPopupWrap", function () {
    return {
        restrict: "EA",
        replace: !0,
        transclude: !0,
        templateUrl: function (a, b) {
            return b.templateUrl || "template/datepicker/popup.html"
        }
    }
}), angular.module("ui.bootstrap.dropdown", ["ui.bootstrap.position"]).constant("dropdownConfig", {
    openClass: "open"
}).service("dropdownService", ["$document", "$rootScope", function (a, b) {
    var c = null;
    this.open = function (b) {
        c || (a.bind("click", d), a.bind("keydown", e)), c && c !== b && (c.isOpen = !1), c = b
    }, this.close = function (b) {
        c === b && (c = null, a.unbind("click", d), a.unbind("keydown", e))
    };
    var d = function (a) {
            if (c && (!a || "disabled" !== c.getAutoClose())) {
                var d = c.getToggleElement();
                if (!(a && d && d[0].contains(a.target))) {
                    var e = c.getDropdownElement();
                    a && "outsideClick" === c.getAutoClose() && e && e[0].contains(a.target) || (c.isOpen = !1, b.$$phase || c.$apply())
                }
            }
        },
        e = function (a) {
            27 === a.which ? (c.focusToggleElement(), d()) : c.isKeynavEnabled() && /(38|40)/.test(a.which) && c.isOpen && (a.preventDefault(), a.stopPropagation(), c.focusDropdownEntry(a.which))
        }
}]).controller("DropdownController", ["$scope", "$attrs", "$parse", "dropdownConfig", "dropdownService", "$animate", "$position", "$document", "$compile", "$templateRequest", function (a, b, c, d, e, f, g, h, i, j) {
    var k, l, m = this,
        n = a.$new(),
        o = d.openClass,
        p = angular.noop,
        q = b.onToggle ? c(b.onToggle) : angular.noop,
        r = !1,
        s = !1;
    this.init = function (d) {
        m.$element = d, b.isOpen && (l = c(b.isOpen), p = l.assign, a.$watch(l, function (a) {
            n.isOpen = !!a
        })), r = angular.isDefined(b.dropdownAppendToBody), s = angular.isDefined(b.keyboardNav), r && m.dropdownMenu && (h.find("body").append(m.dropdownMenu), d.on("$destroy", function () {
            m.dropdownMenu.remove()
        }))
    }, this.toggle = function (a) {
        return n.isOpen = arguments.length ? !!a : !n.isOpen
    }, this.isOpen = function () {
        return n.isOpen
    }, n.getToggleElement = function () {
        return m.toggleElement
    }, n.getAutoClose = function () {
        return b.autoClose || "always"
    }, n.getElement = function () {
        return m.$element
    }, n.isKeynavEnabled = function () {
        return s
    }, n.focusDropdownEntry = function (a) {
        var b = m.dropdownMenu ? angular.element(m.dropdownMenu).find("a") : angular.element(m.$element).find("ul").eq(0).find("a");
        switch (a) {
            case 40:
                m.selectedOption = angular.isNumber(m.selectedOption) ? m.selectedOption === b.length - 1 ? m.selectedOption : m.selectedOption + 1 : 0;
                break;
            case 38:
                if (!angular.isNumber(m.selectedOption)) return;
                m.selectedOption = 0 === m.selectedOption ? 0 : m.selectedOption - 1
        }
        b[m.selectedOption].focus()
    }, n.getDropdownElement = function () {
        return m.dropdownMenu
    }, n.focusToggleElement = function () {
        m.toggleElement && m.toggleElement[0].focus()
    }, n.$watch("isOpen", function (b, c) {
        if (r && m.dropdownMenu) {
            var d = g.positionElements(m.$element, m.dropdownMenu, "bottom-left", !0),
                h = {
                    top: d.top + "px",
                    display: b ? "block" : "none"
                },
                l = m.dropdownMenu.hasClass("dropdown-menu-right");
            l ? (h.left = "auto", h.right = window.innerWidth - (d.left + m.$element.prop("offsetWidth")) + "px") : (h.left = d.left + "px", h.right = "auto"), m.dropdownMenu.css(h)
        }
        if (f[b ? "addClass" : "removeClass"](m.$element, o).then(function () {
                angular.isDefined(b) && b !== c && q(a, {
                    open: !!b
                })
            }), b) m.dropdownMenuTemplateUrl && j(m.dropdownMenuTemplateUrl).then(function (a) {
            k = n.$new(), i(a.trim())(k, function (a) {
                var b = a;
                m.dropdownMenu.replaceWith(b), m.dropdownMenu = b
            })
        }), n.focusToggleElement(), e.open(n);
        else {
            if (m.dropdownMenuTemplateUrl) {
                k && k.$destroy();
                var s = angular.element('<ul class="dropdown-menu"></ul>');
                m.dropdownMenu.replaceWith(s), m.dropdownMenu = s
            }
            e.close(n), m.selectedOption = null
        }
        angular.isFunction(p) && p(a, b)
    }), a.$on("$locationChangeSuccess", function () {
        "disabled" !== n.getAutoClose() && (n.isOpen = !1)
    }), a.$on("$destroy", function () {
        n.$destroy()
    })
}]).directive("dropdown", function () {
    return {
        controller: "DropdownController",
        link: function (a, b, c, d) {
            d.init(b), b.addClass("dropdown")
        }
    }
}).directive("dropdownMenu", function () {
    return {
        restrict: "AC",
        require: "?^dropdown",
        link: function (a, b, c, d) {
            if (d) {
                var e = c.templateUrl;
                e && (d.dropdownMenuTemplateUrl = e), d.dropdownMenu || (d.dropdownMenu = b)
            }
        }
    }
}).directive("keyboardNav", function () {
    return {
        restrict: "A",
        require: "?^dropdown",
        link: function (a, b, c, d) {
            b.bind("keydown", function (a) {
                if (-1 !== [38, 40].indexOf(a.which)) {
                    a.preventDefault(), a.stopPropagation();
                    var b = d.dropdownMenu.find("a");
                    switch (a.which) {
                        case 40:
                            d.selectedOption = angular.isNumber(d.selectedOption) ? d.selectedOption === b.length - 1 ? d.selectedOption : d.selectedOption + 1 : 0;
                            break;
                        case 38:
                            d.selectedOption = 0 === d.selectedOption ? 0 : d.selectedOption - 1
                    }
                    b[d.selectedOption].focus()
                }
            })
        }
    }
}).directive("dropdownToggle", function () {
    return {
        require: "?^dropdown",
        link: function (a, b, c, d) {
            if (d) {
                b.addClass("dropdown-toggle"), d.toggleElement = b;
                var e = function (e) {
                    e.preventDefault(), b.hasClass("disabled") || c.disabled || a.$apply(function () {
                        d.toggle()
                    })
                };
                b.bind("click", e), b.attr({
                    "aria-haspopup": !0,
                    "aria-expanded": !1
                }), a.$watch(d.isOpen, function (a) {
                    b.attr("aria-expanded", !!a)
                }), a.$on("$destroy", function () {
                    b.unbind("click", e)
                })
            }
        }
    }
}), angular.module("ui.bootstrap.modal", []).factory("$$stackedMap", function () {
    return {
        createNew: function () {
            var a = [];
            return {
                add: function (b, c) {
                    a.push({
                        key: b,
                        value: c
                    })
                },
                get: function (b) {
                    for (var c = 0; c < a.length; c++)
                        if (b == a[c].key) return a[c]
                },
                keys: function () {
                    for (var b = [], c = 0; c < a.length; c++) b.push(a[c].key);
                    return b
                },
                top: function () {
                    return a[a.length - 1]
                },
                remove: function (b) {
                    for (var c = -1, d = 0; d < a.length; d++)
                        if (b == a[d].key) {
                            c = d;
                            break
                        }
                    return a.splice(c, 1)[0]
                },
                removeTop: function () {
                    return a.splice(a.length - 1, 1)[0]
                },
                length: function () {
                    return a.length
                }
            }
        }
    }
}).directive("modalBackdrop", ["$animate", "$injector", "$modalStack", function (a, b, c) {
    function d(b, d, f) {
        f.modalInClass && (e ? e(d, {
            addClass: f.modalInClass
        }).start() : a.addClass(d, f.modalInClass), b.$on(c.NOW_CLOSING_EVENT, function (b, c) {
            var g = c();
            e ? e(d, {
                removeClass: f.modalInClass
            }).start().then(g) : a.removeClass(d, f.modalInClass).then(g)
        }))
    }
    var e = null;
    return b.has("$animateCss") && (e = b.get("$animateCss")), {
        restrict: "EA",
        replace: !0,
        templateUrl: "template/modal/backdrop.html",
        compile: function (a, b) {
            return a.addClass(b.backdropClass), d
        }
    }
}]).directive("modalWindow", ["$modalStack", "$q", "$animate", "$injector", function (a, b, c, d) {
    var e = null;
    return d.has("$animateCss") && (e = d.get("$animateCss")), {
        restrict: "EA",
        scope: {
            index: "@"
        },
        replace: !0,
        transclude: !0,
        templateUrl: function (a, b) {
            return b.templateUrl || "template/modal/window.html"
        },
        link: function (d, f, g) {
            f.addClass(g.windowClass || ""), d.size = g.size, d.close = function (b) {
                var c = a.getTop();
                c && c.value.backdrop && "static" != c.value.backdrop && b.target === b.currentTarget && (b.preventDefault(), b.stopPropagation(), a.dismiss(c.key, "backdrop click"))
            }, d.$isRendered = !0;
            var h = b.defer();
            g.$observe("modalRender", function (a) {
                "true" == a && h.resolve()
            }), h.promise.then(function () {
                g.modalInClass && (e ? e(f, {
                    addClass: g.modalInClass
                }).start() : c.addClass(f, g.modalInClass), d.$on(a.NOW_CLOSING_EVENT, function (a, b) {
                    var d = b();
                    e ? e(f, {
                        removeClass: g.modalInClass
                    }).start().then(d) : c.removeClass(f, g.modalInClass).then(d)
                }));
                var b = f[0].querySelectorAll("[autofocus]");
                b.length ? b[0].focus() : f[0].focus();
                var h = a.getTop();
                h && a.modalRendered(h.key)
            })
        }
    }
}]).directive("modalAnimationClass", [function () {
    return {
        compile: function (a, b) {
            b.modalAnimation && a.addClass(b.modalAnimationClass)
        }
    }
}]).directive("modalTransclude", function () {
    return {
        link: function (a, b, c, d, e) {
            e(a.$parent, function (a) {
                b.empty(), b.append(a)
            })
        }
    }
}).factory("$modalStack", ["$animate", "$timeout", "$document", "$compile", "$rootScope", "$q", "$injector", "$$stackedMap", function (a, b, c, d, e, f, g, h) {
    function i() {
        for (var a = -1, b = s.keys(), c = 0; c < b.length; c++) s.get(b[c]).value.backdrop && (a = c);
        return a
    }

    function j(a, b) {
        var d = c.find("body").eq(0),
            e = s.get(a).value;
        s.remove(a), l(e.modalDomEl, e.modalScope, function () {
            d.toggleClass(a.openedClass || r, s.length() > 0)
        }), k(), b && b.focus ? b.focus() : d.focus()
    }

    function k() {
        if (o && -1 == i()) {
            var a = p;
            l(o, p, function () {
                a = null
            }), o = void 0, p = void 0
        }
    }

    function l(b, c, d) {
        function e() {
            e.done || (e.done = !0, n ? n(b, {
                event: "leave"
            }).start().then(function () {
                b.remove()
            }) : a.leave(b), c.$destroy(), d && d())
        }
        var g, h = null,
            i = function () {
                return g || (g = f.defer(), h = g.promise),
                    function () {
                        g.resolve()
                    }
            };
        return c.$broadcast(t.NOW_CLOSING_EVENT, i), f.when(h).then(e)
    }

    function m(a, b, c) {
        return !a.value.modalScope.$broadcast("modal.closing", b, c).defaultPrevented
    }
    var n = null;
    g.has("$animateCss") && (n = g.get("$animateCss"));
    var o, p, q, r = "modal-open",
        s = h.createNew(),
        t = {
            NOW_CLOSING_EVENT: "modal.stack.now-closing"
        },
        u = 0,
        v = "a[href], area[href], input:not([disabled]), button:not([disabled]),select:not([disabled]), textarea:not([disabled]), iframe, object, embed, *[tabindex], *[contenteditable=true]";
    return e.$watch(i, function (a) {
        p && (p.index = a)
    }), c.bind("keydown", function (a) {
        if (a.isDefaultPrevented()) return a;
        var b = s.top();
        if (b && b.value.keyboard) switch (a.which) {
            case 27:
                a.preventDefault(), e.$apply(function () {
                    t.dismiss(b.key, "escape key press")
                });
                break;
            case 9:
                t.loadFocusElementList(b);
                var c = !1;
                a.shiftKey ? t.isFocusInFirstItem(a) && (c = t.focusLastFocusableElement()) : t.isFocusInLastItem(a) && (c = t.focusFirstFocusableElement()), c && (a.preventDefault(), a.stopPropagation())
        }
    }), t.open = function (a, b) {
        var f = c[0].activeElement;
        s.add(a, {
            deferred: b.deferred,
            renderDeferred: b.renderDeferred,
            modalScope: b.scope,
            backdrop: b.backdrop,
            keyboard: b.keyboard,
            openedClass: b.openedClass
        });
        var g = c.find("body").eq(0),
            h = i();
        if (h >= 0 && !o) {
            p = e.$new(!0), p.index = h;
            var j = angular.element('<div modal-backdrop="modal-backdrop"></div>');
            j.attr("backdrop-class", b.backdropClass), b.animation && j.attr("modal-animation", "true"), o = d(j)(p), g.append(o)
        }
        var k = angular.element('<div modal-window="modal-window"></div>');
        k.attr({
            "template-url": b.windowTemplateUrl,
            "window-class": b.windowClass,
            size: b.size,
            index: s.length() - 1,
            animate: "animate"
        }).html(b.content), b.animation && k.attr("modal-animation", "true");
        var l = d(k)(b.scope);
        s.top().value.modalDomEl = l, s.top().value.modalOpener = f, g.append(l), g.addClass(b.openedClass || r), t.clearFocusListCache()
    }, t.close = function (a, b) {
        var c = s.get(a);
        return c && m(c, b, !0) ? (c.value.modalScope.$$uibDestructionScheduled = !0, c.value.deferred.resolve(b), j(a, c.value.modalOpener), !0) : !c
    }, t.dismiss = function (a, b) {
        var c = s.get(a);
        return c && m(c, b, !1) ? (c.value.modalScope.$$uibDestructionScheduled = !0, c.value.deferred.reject(b), j(a, c.value.modalOpener), !0) : !c
    }, t.dismissAll = function (a) {
        for (var b = this.getTop(); b && this.dismiss(b.key, a);) b = this.getTop()
    }, t.getTop = function () {
        return s.top()
    }, t.modalRendered = function (a) {
        var b = s.get(a);
        b && b.value.renderDeferred.resolve()
    }, t.focusFirstFocusableElement = function () {
        return q.length > 0 ? (q[0].focus(), !0) : !1
    }, t.focusLastFocusableElement = function () {
        return q.length > 0 ? (q[q.length - 1].focus(), !0) : !1
    }, t.isFocusInFirstItem = function (a) {
        return q.length > 0 ? (a.target || a.srcElement) == q[0] : !1
    }, t.isFocusInLastItem = function (a) {
        return q.length > 0 ? (a.target || a.srcElement) == q[q.length - 1] : !1
    }, t.clearFocusListCache = function () {
        q = [], u = 0
    }, t.loadFocusElementList = function (a) {
        if ((void 0 === q || !q.length0) && a) {
            var b = a.value.modalDomEl;
            b && b.length && (q = b[0].querySelectorAll(v))
        }
    }, t
}]).provider("$modal", function () {
    var a = {
        options: {
            animation: !0,
            backdrop: !0,
            keyboard: !0
        },
        $get: ["$injector", "$rootScope", "$q", "$templateRequest", "$controller", "$modalStack", function (b, c, d, e, f, g) {
            function h(a) {
                return a.template ? d.when(a.template) : e(angular.isFunction(a.templateUrl) ? a.templateUrl() : a.templateUrl)
            }

            function i(a) {
                var c = [];
                return angular.forEach(a, function (a) {
                    angular.isFunction(a) || angular.isArray(a) ? c.push(d.when(b.invoke(a))) : angular.isString(a) && c.push(d.when(b.get(a)))
                }), c
            }
            var j = {};
            return j.open = function (b) {
                var e = d.defer(),
                    j = d.defer(),
                    k = d.defer(),
                    l = {
                        result: e.promise,
                        opened: j.promise,
                        rendered: k.promise,
                        close: function (a) {
                            return g.close(l, a)
                        },
                        dismiss: function (a) {
                            return g.dismiss(l, a)
                        }
                    };
                if (b = angular.extend({}, a.options, b), b.resolve = b.resolve || {}, !b.template && !b.templateUrl) throw new Error("One of template or templateUrl options is required.");
                var m = d.all([h(b)].concat(i(b.resolve)));
                return m.then(function (a) {
                    var d = (b.scope || c).$new();
                    d.$close = l.close, d.$dismiss = l.dismiss, d.$on("$destroy", function () {
                        d.$$uibDestructionScheduled || d.$dismiss("$uibUnscheduledDestruction")
                    });
                    var h, i = {},
                        j = 1;
                    b.controller && (i.$scope = d, i.$modalInstance = l, angular.forEach(b.resolve, function (b, c) {
                        i[c] = a[j++]
                    }), h = f(b.controller, i), b.controllerAs && (b.bindToController && angular.extend(h, d), d[b.controllerAs] = h)), g.open(l, {
                        scope: d,
                        deferred: e,
                        renderDeferred: k,
                        content: a[0],
                        animation: b.animation,
                        backdrop: b.backdrop,
                        keyboard: b.keyboard,
                        backdropClass: b.backdropClass,
                        windowClass: b.windowClass,
                        windowTemplateUrl: b.windowTemplateUrl,
                        size: b.size,
                        openedClass: b.openedClass
                    })
                }, function (a) {
                    e.reject(a)
                }), m.then(function () {
                    j.resolve(!0)
                }, function (a) {
                    j.reject(a)
                }), l
            }, j
        }]
    };
    return a
}), angular.module("ui.bootstrap.pagination", []).controller("PaginationController", ["$scope", "$attrs", "$parse", function (a, b, c) {
    var d = this,
        e = {
            $setViewValue: angular.noop
        },
        f = b.numPages ? c(b.numPages).assign : angular.noop;
    this.init = function (g, h) {
        e = g, this.config = h, e.$render = function () {
            d.render()
        }, b.itemsPerPage ? a.$parent.$watch(c(b.itemsPerPage), function (b) {
            d.itemsPerPage = parseInt(b, 10), a.totalPages = d.calculateTotalPages()
        }) : this.itemsPerPage = h.itemsPerPage, a.$watch("totalItems", function () {
            a.totalPages = d.calculateTotalPages()
        }), a.$watch("totalPages", function (b) {
            f(a.$parent, b), a.page > b ? a.selectPage(b) : e.$render()
        })
    }, this.calculateTotalPages = function () {
        var b = this.itemsPerPage < 1 ? 1 : Math.ceil(a.totalItems / this.itemsPerPage);
        return Math.max(b || 0, 1)
    }, this.render = function () {
        a.page = parseInt(e.$viewValue, 10) || 1
    }, a.selectPage = function (b, c) {
        c && c.preventDefault();
        var d = !a.ngDisabled || !c;
        d && a.page !== b && b > 0 && b <= a.totalPages && (c && c.target && c.target.blur(), e.$setViewValue(b), e.$render())
    }, a.getText = function (b) {
        return a[b + "Text"] || d.config[b + "Text"]
    }, a.noPrevious = function () {
        return 1 === a.page
    }, a.noNext = function () {
        return a.page === a.totalPages
    }
}]).constant("paginationConfig", {
    itemsPerPage: 10,
    boundaryLinks: !1,
    directionLinks: !0,
    firstText: "First",
    previousText: "Previous",
    nextText: "Next",
    lastText: "Last",
    rotate: !0
}).directive("pagination", ["$parse", "paginationConfig", function (a, b) {
    return {
        restrict: "EA",
        scope: {
            totalItems: "=",
            firstText: "@",
            previousText: "@",
            nextText: "@",
            lastText: "@",
            ngDisabled: "="
        },
        require: ["pagination", "?ngModel"],
        controller: "PaginationController",
        controllerAs: "pagination",
        templateUrl: function (a, b) {
            return b.templateUrl || "template/pagination/pagination.html"
        },
        replace: !0,
        link: function (c, d, e, f) {
            function g(a, b, c) {
                return {
                    number: a,
                    text: b,
                    active: c
                }
            }

            function h(a, b) {
                var c = [],
                    d = 1,
                    e = b,
                    f = angular.isDefined(k) && b > k;
                f && (l ? (d = Math.max(a - Math.floor(k / 2), 1), e = d + k - 1, e > b && (e = b, d = e - k + 1)) : (d = (Math.ceil(a / k) - 1) * k + 1, e = Math.min(d + k - 1, b)));
                for (var h = d; e >= h; h++) {
                    var i = g(h, h, h === a);
                    c.push(i)
                }
                if (f && !l) {
                    if (d > 1) {
                        var j = g(d - 1, "...", !1);
                        c.unshift(j)
                    }
                    if (b > e) {
                        var m = g(e + 1, "...", !1);
                        c.push(m)
                    }
                }
                return c
            }
            var i = f[0],
                j = f[1];
            if (j) {
                var k = angular.isDefined(e.maxSize) ? c.$parent.$eval(e.maxSize) : b.maxSize,
                    l = angular.isDefined(e.rotate) ? c.$parent.$eval(e.rotate) : b.rotate;
                c.boundaryLinks = angular.isDefined(e.boundaryLinks) ? c.$parent.$eval(e.boundaryLinks) : b.boundaryLinks, c.directionLinks = angular.isDefined(e.directionLinks) ? c.$parent.$eval(e.directionLinks) : b.directionLinks, i.init(j, b), e.maxSize && c.$parent.$watch(a(e.maxSize), function (a) {
                    k = parseInt(a, 10), i.render()
                });
                var m = i.render;
                i.render = function () {
                    m(), c.page > 0 && c.page <= c.totalPages && (c.pages = h(c.page, c.totalPages))
                }
            }
        }
    }
}]).constant("pagerConfig", {
    itemsPerPage: 10,
    previousText: "« Previous",
    nextText: "Next »",
    align: !0
}).directive("pager", ["pagerConfig", function (a) {
    return {
        restrict: "EA",
        scope: {
            totalItems: "=",
            previousText: "@",
            nextText: "@"
        },
        require: ["pager", "?ngModel"],
        controller: "PaginationController",
        templateUrl: "template/pagination/pager.html",
        replace: !0,
        link: function (b, c, d, e) {
            var f = e[0],
                g = e[1];
            g && (b.align = angular.isDefined(d.align) ? b.$parent.$eval(d.align) : a.align, f.init(g, a))
        }
    }
}]), angular.module("ui.bootstrap.tooltip", ["ui.bootstrap.position", "ui.bootstrap.bindHtml"]).provider("$tooltip", function () {
    function a(a) {
        var b = /[A-Z]/g,
            c = "-";
        return a.replace(b, function (a, b) {
            return (b ? c : "") + a.toLowerCase()
        })
    }
    var b = {
            placement: "top",
            animation: !0,
            popupDelay: 0,
            useContentExp: !1
        },
        c = {
            mouseenter: "mouseleave",
            click: "click",
            focus: "blur"
        },
        d = {};
    this.options = function (a) {
        angular.extend(d, a)
    }, this.setTriggers = function (a) {
        angular.extend(c, a)
    }, this.$get = ["$window", "$compile", "$timeout", "$document", "$position", "$interpolate", "$rootScope", function (e, f, g, h, i, j, k) {
        return function (e, l, m, n) {
            function o(a) {
                var b = (a || n.trigger || m).split(" "),
                    d = b.map(function (a) {
                        return c[a] || a
                    });
                return {
                    show: b,
                    hide: d
                }
            }
            n = angular.extend({}, b, d, n);
            var p = a(e),
                q = j.startSymbol(),
                r = j.endSymbol(),
                s = "<div " + p + '-popup title="' + q + "title" + r + '" ' + (n.useContentExp ? 'content-exp="contentExp()" ' : 'content="' + q + "content" + r + '" ') + 'placement="' + q + "placement" + r + '" popup-class="' + q + "popupClass" + r + '" animation="animation" is-open="isOpen"origin-scope="origScope" ></div>';
            return {
                restrict: "EA",
                compile: function () {
                    var a = f(s);
                    return function (b, c, d) {
                        function f() {
                            F.isOpen ? m() : j()
                        }

                        function j() {
                            (!E || b.$eval(d[l + "Enable"])) && (t(), F.popupDelay ? B || (B = g(p, F.popupDelay, !1), B.then(function (a) {
                                a()
                            })) : p()())
                        }

                        function m() {
                            q(), k.$$phase || k.$digest()
                        }

                        function p() {
                            return B = null, A && (g.cancel(A), A = null), (n.useContentExp ? F.contentExp() : F.content) ? (r(), y.css({
                                top: 0,
                                left: 0,
                                display: "block"
                            }), H(), F.isOpen = !0, F.$apply(), H) : angular.noop
                        }

                        function q() {
                            F.isOpen = !1, g.cancel(B), B = null, F.animation ? A || (A = g(s, 500)) : s()
                        }

                        function r() {
                            y && s(), z = F.$new(), y = a(z, function (a) {
                                C ? h.find("body").append(a) : c.after(a)
                            }), n.useContentExp && (z.$watch("contentExp()", function (a) {
                                !a && F.isOpen && q()
                            }), z.$watch(function () {
                                G || (G = !0, z.$$postDigest(function () {
                                    G = !1, I()
                                }))
                            }))
                        }

                        function s() {
                            A = null, y && (y.remove(), y = null), z && (z.$destroy(), z = null)
                        }

                        function t() {
                            u(), v(), w()
                        }

                        function u() {
                            F.popupClass = d[l + "Class"]
                        }

                        function v() {
                            var a = d[l + "Placement"];
                            F.placement = angular.isDefined(a) ? a : n.placement
                        }

                        function w() {
                            var a = d[l + "PopupDelay"],
                                b = parseInt(a, 10);
                            F.popupDelay = isNaN(b) ? n.popupDelay : b
                        }

                        function x() {
                            var a = d[l + "Trigger"];
                            J(), D = o(a), D.show.forEach(function (a, b) {
                                a === D.hide[b] ? c.bind(a, f) : a && (c.bind(a, j), c.bind(D.hide[b], m))
                            })
                        }
                        var y, z, A, B, C = angular.isDefined(n.appendToBody) ? n.appendToBody : !1,
                            D = o(void 0),
                            E = angular.isDefined(d[l + "Enable"]),
                            F = b.$new(!0),
                            G = !1,
                            H = function () {
                                if (y) {
                                    var a = i.positionElements(c, y, F.placement, C);
                                    a.top += "px", a.left += "px", y.css(a)
                                }
                            },
                            I = function () {
                                g(H, 0, !1)
                            };
                        F.origScope = b, F.isOpen = !1, F.contentExp = function () {
                            return b.$eval(d[e])
                        }, n.useContentExp || d.$observe(e, function (a) {
                            F.content = a, !a && F.isOpen ? q() : I()
                        }), d.$observe("disabled", function (a) {
                            B && a && g.cancel(B), a && F.isOpen && q()
                        }), d.$observe(l + "Title", function (a) {
                            F.title = a, I()
                        }), d.$observe(l + "Placement", function () {
                            F.isOpen && g(function () {
                                v(), p()()
                            }, 0, !1)
                        });
                        var J = function () {
                            D.show.forEach(function (a) {
                                c.unbind(a, j)
                            }), D.hide.forEach(function (a) {
                                c.unbind(a, m)
                            })
                        };
                        x();
                        var K = b.$eval(d[l + "Animation"]);
                        F.animation = angular.isDefined(K) ? !!K : n.animation;
                        var L = b.$eval(d[l + "AppendToBody"]);
                        C = angular.isDefined(L) ? L : C, C && b.$on("$locationChangeSuccess", function () {
                            F.isOpen && q()
                        }), b.$on("$destroy", function () {
                            g.cancel(A), g.cancel(B), J(), s(), F = null
                        })
                    }
                }
            }
        }
    }]
}).directive("tooltipTemplateTransclude", ["$animate", "$sce", "$compile", "$templateRequest", function (a, b, c, d) {
    return {
        link: function (e, f, g) {
            var h, i, j, k = e.$eval(g.tooltipTemplateTranscludeScope),
                l = 0,
                m = function () {
                    i && (i.remove(), i = null), h && (h.$destroy(), h = null), j && (a.leave(j).then(function () {
                        i = null
                    }), i = j, j = null)
                };
            e.$watch(b.parseAsResourceUrl(g.tooltipTemplateTransclude), function (b) {
                var g = ++l;
                b ? (d(b, !0).then(function (d) {
                    if (g === l) {
                        var e = k.$new(),
                            i = d,
                            n = c(i)(e, function (b) {
                                m(), a.enter(b, f)
                            });
                        h = e, j = n, h.$emit("$includeContentLoaded", b)
                    }
                }, function () {
                    g === l && (m(), e.$emit("$includeContentError", b))
                }), e.$emit("$includeContentRequested", b)) : m()
            }), e.$on("$destroy", m)
        }
    }
}]).directive("tooltipClasses", function () {
    return {
        restrict: "A",
        link: function (a, b, c) {
            a.placement && b.addClass(a.placement), a.popupClass && b.addClass(a.popupClass), a.animation() && b.addClass(c.tooltipAnimationClass)
        }
    }
}).directive("tooltipPopup", function () {
    return {
        restrict: "EA",
        replace: !0,
        scope: {
            content: "@",
            placement: "@",
            popupClass: "@",
            animation: "&",
            isOpen: "&"
        },
        templateUrl: "template/tooltip/tooltip-popup.html"
    }
}).directive("tooltip", ["$tooltip", function (a) {
    return a("tooltip", "tooltip", "mouseenter")
}]).directive("tooltipTemplatePopup", function () {
    return {
        restrict: "EA",
        replace: !0,
        scope: {
            contentExp: "&",
            placement: "@",
            popupClass: "@",
            animation: "&",
            isOpen: "&",
            originScope: "&"
        },
        templateUrl: "template/tooltip/tooltip-template-popup.html"
    }
}).directive("tooltipTemplate", ["$tooltip", function (a) {
    return a("tooltipTemplate", "tooltip", "mouseenter", {
        useContentExp: !0
    })
}]).directive("tooltipHtmlPopup", function () {
    return {
        restrict: "EA",
        replace: !0,
        scope: {
            contentExp: "&",
            placement: "@",
            popupClass: "@",
            animation: "&",
            isOpen: "&"
        },
        templateUrl: "template/tooltip/tooltip-html-popup.html"
    }
}).directive("tooltipHtml", ["$tooltip", function (a) {
    return a("tooltipHtml", "tooltip", "mouseenter", {
        useContentExp: !0
    })
}]).directive("tooltipHtmlUnsafePopup", function () {
    return {
        restrict: "EA",
        replace: !0,
        scope: {
            content: "@",
            placement: "@",
            popupClass: "@",
            animation: "&",
            isOpen: "&"
        },
        templateUrl: "template/tooltip/tooltip-html-unsafe-popup.html"
    }
}).value("tooltipHtmlUnsafeSuppressDeprecated", !1).directive("tooltipHtmlUnsafe", ["$tooltip", "tooltipHtmlUnsafeSuppressDeprecated", "$log", function (a, b, c) {
    return b || c.warn("tooltip-html-unsafe is now deprecated. Use tooltip-html or tooltip-template instead."), a("tooltipHtmlUnsafe", "tooltip", "mouseenter")
}]), angular.module("ui.bootstrap.popover", ["ui.bootstrap.tooltip"]).directive("popoverTemplatePopup", function () {
    return {
        restrict: "EA",
        replace: !0,
        scope: {
            title: "@",
            contentExp: "&",
            placement: "@",
            popupClass: "@",
            animation: "&",
            isOpen: "&",
            originScope: "&"
        },
        templateUrl: "template/popover/popover-template.html"
    }
}).directive("popoverTemplate", ["$tooltip", function (a) {
    return a("popoverTemplate", "popover", "click", {
        useContentExp: !0
    })
}]).directive("popoverHtmlPopup", function () {
    return {
        restrict: "EA",
        replace: !0,
        scope: {
            contentExp: "&",
            title: "@",
            placement: "@",
            popupClass: "@",
            animation: "&",
            isOpen: "&"
        },
        templateUrl: "template/popover/popover-html.html"
    }
}).directive("popoverHtml", ["$tooltip", function (a) {
    return a("popoverHtml", "popover", "click", {
        useContentExp: !0
    })
}]).directive("popoverPopup", function () {
    return {
        restrict: "EA",
        replace: !0,
        scope: {
            title: "@",
            content: "@",
            placement: "@",
            popupClass: "@",
            animation: "&",
            isOpen: "&"
        },
        templateUrl: "template/popover/popover.html"
    }
}).directive("popover", ["$tooltip", function (a) {
    return a("popover", "popover", "click")
}]), angular.module("ui.bootstrap.progressbar", []).constant("progressConfig", {
    animate: !0,
    max: 100
}).controller("ProgressController", ["$scope", "$attrs", "progressConfig", function (a, b, c) {
    var d = this,
        e = angular.isDefined(b.animate) ? a.$parent.$eval(b.animate) : c.animate;
    this.bars = [], a.max = angular.isDefined(a.max) ? a.max : c.max, this.addBar = function (b, c) {
        e || c.css({
            transition: "none"
        }), this.bars.push(b), b.max = a.max, b.$watch("value", function () {
            b.recalculatePercentage()
        }), b.recalculatePercentage = function () {
            b.percent = +(100 * b.value / b.max).toFixed(2);
            var a = 0;
            d.bars.forEach(function (b) {
                a += b.percent
            }), a > 100 && (b.percent -= a - 100)
        }, b.$on("$destroy", function () {
            c = null, d.removeBar(b)
        })
    }, this.removeBar = function (a) {
        this.bars.splice(this.bars.indexOf(a), 1)
    }, a.$watch("max", function () {
        d.bars.forEach(function (b) {
            b.max = a.max, b.recalculatePercentage()
        })
    })
}]).directive("progress", function () {
    return {
        restrict: "EA",
        replace: !0,
        transclude: !0,
        controller: "ProgressController",
        require: "progress",
        scope: {
            max: "=?"
        },
        templateUrl: "template/progressbar/progress.html"
    }
}).directive("bar", function () {
    return {
        restrict: "EA",
        replace: !0,
        transclude: !0,
        require: "^progress",
        scope: {
            value: "=",
            type: "@"
        },
        templateUrl: "template/progressbar/bar.html",
        link: function (a, b, c, d) {
            d.addBar(a, b)
        }
    }
}).directive("progressbar", function () {
    return {
        restrict: "EA",
        replace: !0,
        transclude: !0,
        controller: "ProgressController",
        scope: {
            value: "=",
            max: "=?",
            type: "@"
        },
        templateUrl: "template/progressbar/progressbar.html",
        link: function (a, b, c, d) {
            d.addBar(a, angular.element(b.children()[0]))
        }
    }
}), angular.module("ui.bootstrap.rating", []).constant("ratingConfig", {
    max: 5,
    stateOn: null,
    stateOff: null,
    titles: ["one", "two", "three", "four", "five"]
}).controller("RatingController", ["$scope", "$attrs", "ratingConfig", function (a, b, c) {
    var d = {
        $setViewValue: angular.noop
    };
    this.init = function (e) {
        d = e, d.$render = this.render, d.$formatters.push(function (a) {
            return angular.isNumber(a) && a << 0 !== a && (a = Math.round(a)), a
        }), this.stateOn = angular.isDefined(b.stateOn) ? a.$parent.$eval(b.stateOn) : c.stateOn, this.stateOff = angular.isDefined(b.stateOff) ? a.$parent.$eval(b.stateOff) : c.stateOff;
        var f = angular.isDefined(b.titles) ? a.$parent.$eval(b.titles) : c.titles;
        this.titles = angular.isArray(f) && f.length > 0 ? f : c.titles;
        var g = angular.isDefined(b.ratingStates) ? a.$parent.$eval(b.ratingStates) : new Array(angular.isDefined(b.max) ? a.$parent.$eval(b.max) : c.max);
        a.range = this.buildTemplateObjects(g)
    }, this.buildTemplateObjects = function (a) {
        for (var b = 0, c = a.length; c > b; b++) a[b] = angular.extend({
            index: b
        }, {
            stateOn: this.stateOn,
            stateOff: this.stateOff,
            title: this.getTitle(b)
        }, a[b]);
        return a
    }, this.getTitle = function (a) {
        return a >= this.titles.length ? a + 1 : this.titles[a]
    }, a.rate = function (b) {
        !a.readonly && b >= 0 && b <= a.range.length && (d.$setViewValue(d.$viewValue === b ? 0 : b), d.$render())
    }, a.enter = function (b) {
        a.readonly || (a.value = b), a.onHover({
            value: b
        })
    }, a.reset = function () {
        a.value = d.$viewValue, a.onLeave()
    }, a.onKeydown = function (b) {
        /(37|38|39|40)/.test(b.which) && (b.preventDefault(), b.stopPropagation(), a.rate(a.value + (38 === b.which || 39 === b.which ? 1 : -1)))
    }, this.render = function () {
        a.value = d.$viewValue
    }
}]).directive("rating", function () {
    return {
        restrict: "EA",
        require: ["rating", "ngModel"],
        scope: {
            readonly: "=?",
            onHover: "&",
            onLeave: "&"
        },
        controller: "RatingController",
        templateUrl: "template/rating/rating.html",
        replace: !0,
        link: function (a, b, c, d) {
            var e = d[0],
                f = d[1];
            e.init(f)
        }
    }
}), angular.module("ui.bootstrap.tabs", []).controller("TabsetController", ["$scope", function (a) {
    var b = this,
        c = b.tabs = a.tabs = [];
    b.select = function (a) {
        angular.forEach(c, function (b) {
            b.active && b !== a && (b.active = !1, b.onDeselect())
        }), a.active = !0, a.onSelect()
    }, b.addTab = function (a) {
        c.push(a), 1 === c.length && a.active !== !1 ? a.active = !0 : a.active ? b.select(a) : a.active = !1
    }, b.removeTab = function (a) {
        var e = c.indexOf(a);
        if (a.active && c.length > 1 && !d) {
            var f = e == c.length - 1 ? e - 1 : e + 1;
            b.select(c[f])
        }
        c.splice(e, 1)
    };
    var d;
    a.$on("$destroy", function () {
        d = !0
    })
}]).directive("tabset", function () {
    return {
        restrict: "EA",
        transclude: !0,
        replace: !0,
        scope: {
            type: "@"
        },
        controller: "TabsetController",
        templateUrl: "template/tabs/tabset.html",
        link: function (a, b, c) {
            a.vertical = angular.isDefined(c.vertical) ? a.$parent.$eval(c.vertical) : !1, a.justified = angular.isDefined(c.justified) ? a.$parent.$eval(c.justified) : !1
        }
    }
}).directive("tab", ["$parse", "$log", function (a, b) {
    return {
        require: "^tabset",
        restrict: "EA",
        replace: !0,
        templateUrl: "template/tabs/tab.html",
        transclude: !0,
        scope: {
            active: "=?",
            heading: "@",
            onSelect: "&select",
            onDeselect: "&deselect"
        },
        controller: function () {},
        link: function (c, d, e, f, g) {
            c.$watch("active", function (a) {
                a && f.select(c)
            }), c.disabled = !1, e.disable && c.$parent.$watch(a(e.disable), function (a) {
                c.disabled = !!a
            }), e.disabled && (b.warn('Use of "disabled" attribute has been deprecated, please use "disable"'), c.$parent.$watch(a(e.disabled), function (a) {
                c.disabled = !!a
            })), c.select = function () {
                c.disabled || (c.active = !0)
            }, f.addTab(c), c.$on("$destroy", function () {
                f.removeTab(c)
            }), c.$transcludeFn = g
        }
    }
}]).directive("tabHeadingTransclude", [function () {
    return {
        restrict: "A",
        require: "^tab",
        link: function (a, b) {
            a.$watch("headingElement", function (a) {
                a && (b.html(""), b.append(a))
            })
        }
    }
}]).directive("tabContentTransclude", function () {
    function a(a) {
        return a.tagName && (a.hasAttribute("tab-heading") || a.hasAttribute("data-tab-heading") || "tab-heading" === a.tagName.toLowerCase() || "data-tab-heading" === a.tagName.toLowerCase())
    }
    return {
        restrict: "A",
        require: "^tabset",
        link: function (b, c, d) {
            var e = b.$eval(d.tabContentTransclude);
            e.$transcludeFn(e.$parent, function (b) {
                angular.forEach(b, function (b) {
                    a(b) ? e.headingElement = b : c.append(b)
                })
            })
        }
    }
}), angular.module("ui.bootstrap.timepicker", []).constant("timepickerConfig", {
    hourStep: 1,
    minuteStep: 1,
    showMeridian: !0,
    meridians: null,
    readonlyInput: !1,
    mousewheel: !0,
    arrowkeys: !0,
    showSpinners: !0
}).controller("TimepickerController", ["$scope", "$attrs", "$parse", "$log", "$locale", "timepickerConfig", function (a, b, c, d, e, f) {
    function g() {
        var b = parseInt(a.hours, 10),
            c = a.showMeridian ? b > 0 && 13 > b : b >= 0 && 24 > b;
        return c ? (a.showMeridian && (12 === b && (b = 0), a.meridian === q[1] && (b += 12)), b) : void 0
    }

    function h() {
        var b = parseInt(a.minutes, 10);
        return b >= 0 && 60 > b ? b : void 0
    }

    function i(a) {
        return angular.isDefined(a) && a.toString().length < 2 ? "0" + a : a.toString()
    }

    function j(a) {
        k(), p.$setViewValue(new Date(o)), l(a)
    }

    function k() {
        p.$setValidity("time", !0), a.invalidHours = !1, a.invalidMinutes = !1
    }

    function l(b) {
        var c = o.getHours(),
            d = o.getMinutes();
        a.showMeridian && (c = 0 === c || 12 === c ? 12 : c % 12), a.hours = "h" === b ? c : i(c), "m" !== b && (a.minutes = i(d)), a.meridian = o.getHours() < 12 ? q[0] : q[1]
    }

    function m(a, b) {
        var c = new Date(a.getTime() + 6e4 * b),
            d = new Date(a);
        return d.setHours(c.getHours(), c.getMinutes()), d
    }

    function n(a) {
        o = m(o, a), j()
    }
    var o = new Date,
        p = {
            $setViewValue: angular.noop
        },
        q = angular.isDefined(b.meridians) ? a.$parent.$eval(b.meridians) : f.meridians || e.DATETIME_FORMATS.AMPMS;
    this.init = function (c, d) {
        p = c, p.$render = this.render, p.$formatters.unshift(function (a) {
            return a ? new Date(a) : null
        });
        var e = d.eq(0),
            g = d.eq(1),
            h = angular.isDefined(b.mousewheel) ? a.$parent.$eval(b.mousewheel) : f.mousewheel;
        h && this.setupMousewheelEvents(e, g);
        var i = angular.isDefined(b.arrowkeys) ? a.$parent.$eval(b.arrowkeys) : f.arrowkeys;
        i && this.setupArrowkeyEvents(e, g), a.readonlyInput = angular.isDefined(b.readonlyInput) ? a.$parent.$eval(b.readonlyInput) : f.readonlyInput, this.setupInputEvents(e, g)
    };
    var r = f.hourStep;
    b.hourStep && a.$parent.$watch(c(b.hourStep), function (a) {
        r = parseInt(a, 10)
    });
    var s = f.minuteStep;
    b.minuteStep && a.$parent.$watch(c(b.minuteStep), function (a) {
        s = parseInt(a, 10)
    });
    var t;
    a.$parent.$watch(c(b.min), function (a) {
        var b = new Date(a);
        t = isNaN(b) ? void 0 : b
    });
    var u;
    a.$parent.$watch(c(b.max), function (a) {
        var b = new Date(a);
        u = isNaN(b) ? void 0 : b
    }), a.noIncrementHours = function () {
        var a = m(o, 60 * r);
        return a > u || o > a && t > a
    }, a.noDecrementHours = function () {
        var a = m(o, 60 * -r);
        return t > a || a > o && a > u
    }, a.noIncrementMinutes = function () {
        var a = m(o, s);
        return a > u || o > a && t > a
    }, a.noDecrementMinutes = function () {
        var a = m(o, -s);
        return t > a || a > o && a > u
    }, a.noToggleMeridian = function () {
        return o.getHours() < 13 ? m(o, 720) > u : m(o, -720) < t
    }, a.showMeridian = f.showMeridian, b.showMeridian && a.$parent.$watch(c(b.showMeridian), function (b) {
        if (a.showMeridian = !!b, p.$error.time) {
            var c = g(),
                d = h();
            angular.isDefined(c) && angular.isDefined(d) && (o.setHours(c), j())
        } else l()
    }), this.setupMousewheelEvents = function (b, c) {
        var d = function (a) {
            a.originalEvent && (a = a.originalEvent);
            var b = a.wheelDelta ? a.wheelDelta : -a.deltaY;
            return a.detail || b > 0
        };
        b.bind("mousewheel wheel", function (b) {
            a.$apply(d(b) ? a.incrementHours() : a.decrementHours()), b.preventDefault()
        }), c.bind("mousewheel wheel", function (b) {
            a.$apply(d(b) ? a.incrementMinutes() : a.decrementMinutes()), b.preventDefault()
        })
    }, this.setupArrowkeyEvents = function (b, c) {
        b.bind("keydown", function (b) {
            38 === b.which ? (b.preventDefault(), a.incrementHours(), a.$apply()) : 40 === b.which && (b.preventDefault(), a.decrementHours(), a.$apply())
        }), c.bind("keydown", function (b) {
            38 === b.which ? (b.preventDefault(), a.incrementMinutes(), a.$apply()) : 40 === b.which && (b.preventDefault(), a.decrementMinutes(), a.$apply())
        })
    }, this.setupInputEvents = function (b, c) {
        if (a.readonlyInput) return a.updateHours = angular.noop, void(a.updateMinutes = angular.noop);
        var d = function (b, c) {
            p.$setViewValue(null), p.$setValidity("time", !1), angular.isDefined(b) && (a.invalidHours = b), angular.isDefined(c) && (a.invalidMinutes = c)
        };
        a.updateHours = function () {
            var a = g();
            angular.isDefined(a) ? (o.setHours(a), t > o || o > u ? d(!0) : j("h")) : d(!0)
        }, b.bind("blur", function () {
            !a.invalidHours && a.hours < 10 && a.$apply(function () {
                a.hours = i(a.hours)
            })
        }), a.updateMinutes = function () {
            var a = h();
            angular.isDefined(a) ? (o.setMinutes(a), t > o || o > u ? d(void 0, !0) : j("m")) : d(void 0, !0)
        }, c.bind("blur", function () {
            !a.invalidMinutes && a.minutes < 10 && a.$apply(function () {
                a.minutes = i(a.minutes)
            })
        })
    }, this.render = function () {
        var b = p.$viewValue;
        isNaN(b) ? (p.$setValidity("time", !1), d.error('Timepicker directive: "ng-model" value must be a Date object, a number of milliseconds since 01.01.1970 or a string representing an RFC2822 or ISO 8601 date.')) : (b && (o = b), t > o || o > u ? (p.$setValidity("time", !1), a.invalidHours = !0, a.invalidMinutes = !0) : k(), l())
    }, a.showSpinners = angular.isDefined(b.showSpinners) ? a.$parent.$eval(b.showSpinners) : f.showSpinners, a.incrementHours = function () {
        a.noIncrementHours() || n(60 * r)
    }, a.decrementHours = function () {
        a.noDecrementHours() || n(60 * -r)
    }, a.incrementMinutes = function () {
        a.noIncrementMinutes() || n(s)
    }, a.decrementMinutes = function () {
        a.noDecrementMinutes() || n(-s)
    }, a.toggleMeridian = function () {
        a.noToggleMeridian() || n(720 * (o.getHours() < 12 ? 1 : -1))
    }
}]).directive("timepicker", function () {
    return {
        restrict: "EA",
        require: ["timepicker", "?^ngModel"],
        controller: "TimepickerController",
        replace: !0,
        scope: {},
        templateUrl: "template/timepicker/timepicker.html",
        link: function (a, b, c, d) {
            var e = d[0],
                f = d[1];
            f && e.init(f, b.find("input"))
        }
    }
}), angular.module("ui.bootstrap.transition", []).value("$transitionSuppressDeprecated", !1).factory("$transition", ["$q", "$timeout", "$rootScope", "$log", "$transitionSuppressDeprecated", function (a, b, c, d, e) {
    function f(a) {
        for (var b in a)
            if (void 0 !== h.style[b]) return a[b]
    }
    e || d.warn("$transition is now deprecated. Use $animate from ngAnimate instead.");
    var g = function (d, e, f) {
            f = f || {};
            var h = a.defer(),
                i = g[f.animation ? "animationEndEventName" : "transitionEndEventName"],
                j = function () {
                    c.$apply(function () {
                        d.unbind(i, j), h.resolve(d)
                    })
                };
            return i && d.bind(i, j), b(function () {
                angular.isString(e) ? d.addClass(e) : angular.isFunction(e) ? e(d) : angular.isObject(e) && d.css(e), i || h.resolve(d)
            }), h.promise.cancel = function () {
                i && d.unbind(i, j), h.reject("Transition cancelled")
            }, h.promise
        },
        h = document.createElement("trans"),
        i = {
            WebkitTransition: "webkitTransitionEnd",
            MozTransition: "transitionend",
            OTransition: "oTransitionEnd",
            transition: "transitionend"
        },
        j = {
            WebkitTransition: "webkitAnimationEnd",
            MozTransition: "animationend",
            OTransition: "oAnimationEnd",
            transition: "animationend"
        };
    return g.transitionEndEventName = f(i), g.animationEndEventName = f(j), g
}]), angular.module("ui.bootstrap.typeahead", ["ui.bootstrap.position", "ui.bootstrap.bindHtml"]).factory("typeaheadParser", ["$parse", function (a) {
    var b = /^\s*([\s\S]+?)(?:\s+as\s+([\s\S]+?))?\s+for\s+(?:([\$\w][\$\w\d]*))\s+in\s+([\s\S]+?)$/;
    return {
        parse: function (c) {
            var d = c.match(b);
            if (!d) throw new Error('Expected typeahead specification in form of "_modelValue_ (as _label_)? for _item_ in _collection_" but got "' + c + '".');
            return {
                itemName: d[3],
                source: a(d[4]),
                viewMapper: a(d[2] || d[1]),
                modelMapper: a(d[1])
            }
        }
    }
}]).directive("typeahead", ["$compile", "$parse", "$q", "$timeout", "$document", "$window", "$rootScope", "$position", "typeaheadParser", function (a, b, c, d, e, f, g, h, i) {
    var j = [9, 13, 27, 38, 40],
        k = 200;
    return {
        require: "ngModel",
        link: function (l, m, n, o) {
            function p() {
                G.moveInProgress || (G.moveInProgress = !0, G.$digest()), N && d.cancel(N), N = d(function () {
                    G.matches.length && q(), G.moveInProgress = !1, G.$digest()
                }, k)
            }

            function q() {
                G.position = B ? h.offset(m) : h.position(m), G.position.top += m.prop("offsetHeight")
            }
            var r = l.$eval(n.typeaheadMinLength);
            r || 0 === r || (r = 1);
            var s, t, u = l.$eval(n.typeaheadWaitMs) || 0,
                v = l.$eval(n.typeaheadEditable) !== !1,
                w = b(n.typeaheadLoading).assign || angular.noop,
                x = b(n.typeaheadOnSelect),
                y = angular.isDefined(n.typeaheadSelectOnBlur) ? l.$eval(n.typeaheadSelectOnBlur) : !1,
                z = b(n.typeaheadNoResults).assign || angular.noop,
                A = n.typeaheadInputFormatter ? b(n.typeaheadInputFormatter) : void 0,
                B = n.typeaheadAppendToBody ? l.$eval(n.typeaheadAppendToBody) : !1,
                C = l.$eval(n.typeaheadFocusFirst) !== !1,
                D = n.typeaheadSelectOnExact ? l.$eval(n.typeaheadSelectOnExact) : !1,
                E = b(n.ngModel).assign,
                F = i.parse(n.typeahead),
                G = l.$new();
            l.$on("$destroy", function () {
                G.$destroy()
            });
            var H = "typeahead-" + G.$id + "-" + Math.floor(1e4 * Math.random());
            m.attr({
                "aria-autocomplete": "list",
                "aria-expanded": !1,
                "aria-owns": H
            });
            var I = angular.element("<div typeahead-popup></div>");
            I.attr({
                id: H,
                matches: "matches",
                active: "activeIdx",
                select: "select(activeIdx)",
                "move-in-progress": "moveInProgress",
                query: "query",
                position: "position"
            }), angular.isDefined(n.typeaheadTemplateUrl) && I.attr("template-url", n.typeaheadTemplateUrl);
            var J = function () {
                    G.matches = [], G.activeIdx = -1, m.attr("aria-expanded", !1)
                },
                K = function (a) {
                    return H + "-option-" + a
                };
            G.$watch("activeIdx", function (a) {
                0 > a ? m.removeAttr("aria-activedescendant") : m.attr("aria-activedescendant", K(a))
            });
            var L = function (a, b) {
                    return G.matches.length > b && a ? a.toUpperCase() === G.matches[b].label.toUpperCase() : !1
                },
                M = function (a) {
                    var b = {
                        $viewValue: a
                    };
                    w(l, !0), z(l, !1), c.when(F.source(l, b)).then(function (c) {
                        var d = a === o.$viewValue;
                        if (d && s)
                            if (c && c.length > 0) {
                                G.activeIdx = C ? 0 : -1, z(l, !1), G.matches.length = 0;
                                for (var e = 0; e < c.length; e++) b[F.itemName] = c[e],
                                    G.matches.push({
                                        id: K(e),
                                        label: F.viewMapper(G, b),
                                        model: c[e]
                                    });
                                G.query = a, q(), m.attr("aria-expanded", !0), D && 1 === G.matches.length && L(a, 0) && G.select(0)
                            } else J(), z(l, !0);
                        d && w(l, !1)
                    }, function () {
                        J(), w(l, !1), z(l, !0)
                    })
                };
            B && (angular.element(f).bind("resize", p), e.find("body").bind("scroll", p));
            var N;
            G.moveInProgress = !1, J(), G.query = void 0;
            var O, P = function (a) {
                    O = d(function () {
                        M(a)
                    }, u)
                },
                Q = function () {
                    O && d.cancel(O)
                };
            o.$parsers.unshift(function (a) {
                return s = !0, 0 === r || a && a.length >= r ? u > 0 ? (Q(), P(a)) : M(a) : (w(l, !1), Q(), J()), v ? a : a ? void o.$setValidity("editable", !1) : (o.$setValidity("editable", !0), null)
            }), o.$formatters.push(function (a) {
                var b, c, d = {};
                return v || o.$setValidity("editable", !0), A ? (d.$model = a, A(l, d)) : (d[F.itemName] = a, b = F.viewMapper(l, d), d[F.itemName] = void 0, c = F.viewMapper(l, d), b !== c ? b : a)
            }), G.select = function (a) {
                var b, c, e = {};
                t = !0, e[F.itemName] = c = G.matches[a].model, b = F.modelMapper(l, e), E(l, b), o.$setValidity("editable", !0), o.$setValidity("parse", !0), x(l, {
                    $item: c,
                    $model: b,
                    $label: F.viewMapper(l, e)
                }), J(), d(function () {
                    m[0].focus()
                }, 0, !1)
            }, m.bind("keydown", function (a) {
                if (0 !== G.matches.length && -1 !== j.indexOf(a.which)) {
                    if (-1 === G.activeIdx && (9 === a.which || 13 === a.which)) return J(), void G.$digest();
                    a.preventDefault(), 40 === a.which ? (G.activeIdx = (G.activeIdx + 1) % G.matches.length, G.$digest()) : 38 === a.which ? (G.activeIdx = (G.activeIdx > 0 ? G.activeIdx : G.matches.length) - 1, G.$digest()) : 13 === a.which || 9 === a.which ? G.$apply(function () {
                        G.select(G.activeIdx)
                    }) : 27 === a.which && (a.stopPropagation(), J(), G.$digest())
                }
            }), m.bind("blur", function () {
                y && G.matches.length && -1 !== G.activeIdx && !t && (t = !0, G.$apply(function () {
                    G.select(G.activeIdx)
                })), s = !1, t = !1
            });
            var R = function (a) {
                m[0] !== a.target && 3 !== a.which && 0 !== G.matches.length && (J(), g.$$phase || G.$digest())
            };
            e.bind("click", R), l.$on("$destroy", function () {
                e.unbind("click", R), B && S.remove(), I.remove()
            });
            var S = a(I)(G);
            B ? e.find("body").append(S) : m.after(S)
        }
    }
}]).directive("typeaheadPopup", function () {
    return {
        restrict: "EA",
        scope: {
            matches: "=",
            query: "=",
            active: "=",
            position: "&",
            moveInProgress: "=",
            select: "&"
        },
        replace: !0,
        templateUrl: "template/typeahead/typeahead-popup.html",
        link: function (a, b, c) {
            a.templateUrl = c.templateUrl, a.isOpen = function () {
                return a.matches.length > 0
            }, a.isActive = function (b) {
                return a.active == b
            }, a.selectActive = function (b) {
                a.active = b
            }, a.selectMatch = function (b) {
                a.select({
                    activeIdx: b
                })
            }
        }
    }
}).directive("typeaheadMatch", ["$templateRequest", "$compile", "$parse", function (a, b, c) {
    return {
        restrict: "EA",
        scope: {
            index: "=",
            match: "=",
            query: "="
        },
        link: function (d, e, f) {
            var g = c(f.templateUrl)(d.$parent) || "template/typeahead/typeahead-match.html";
            a(g).then(function (a) {
                b(a.trim())(d, function (a) {
                    e.replaceWith(a)
                })
            })
        }
    }
}]).filter("typeaheadHighlight", function () {
    function a(a) {
        return a.replace(/([.?*+^$[\]\\(){}|-])/g, "\\$1")
    }
    return function (b, c) {
        return c ? ("" + b).replace(new RegExp(a(c), "gi"), "<strong>$&</strong>") : b
    }
}), angular.module("template/accordion/accordion-group.html", []).run(["$templateCache", function (a) {
    a.put("template/accordion/accordion-group.html", '<div class="panel panel-default" ng-class="{\'panel-open\': isOpen}">\n  <div class="panel-heading">\n    <h4 class="panel-title">\n      <a href tabindex="0" class="accordion-toggle" ng-click="toggleOpen()" accordion-transclude="heading"><span ng-class="{\'text-muted\': isDisabled}">{{heading}}</span></a>\n    </h4>\n  </div>\n  <div class="panel-collapse collapse" collapse="!isOpen">\n	  <div class="panel-body" ng-transclude></div>\n  </div>\n</div>\n')
}]), angular.module("template/accordion/accordion.html", []).run(["$templateCache", function (a) {
    a.put("template/accordion/accordion.html", '<div class="panel-group" ng-transclude></div>')
}]), angular.module("template/alert/alert.html", []).run(["$templateCache", function (a) {
    a.put("template/alert/alert.html", '<div class="alert" ng-class="[\'alert-\' + (type || \'warning\'), closeable ? \'alert-dismissible\' : null]" role="alert">\n    <button ng-show="closeable" type="button" class="close" ng-click="close($event)">\n        <span aria-hidden="true">&times;</span>\n        <span class="sr-only">Close</span>\n    </button>\n    <div ng-transclude></div>\n</div>\n')
}]), angular.module("template/carousel/carousel.html", []).run(["$templateCache", function (a) {
    a.put("template/carousel/carousel.html", '<div ng-mouseenter="pause()" ng-mouseleave="play()" class="carousel" ng-swipe-right="prev()" ng-swipe-left="next()">\n    <ol class="carousel-indicators" ng-show="slides.length > 1">\n        <li ng-repeat="slide in slides | orderBy:indexOfSlide track by $index" ng-class="{active: isActive(slide)}" ng-click="select(slide)"></li>\n    </ol>\n    <div class="carousel-inner" ng-transclude></div>\n    <a class="left carousel-control" ng-click="prev()" ng-show="slides.length > 1"><span class="glyphicon glyphicon-chevron-left"></span></a>\n    <a class="right carousel-control" ng-click="next()" ng-show="slides.length > 1"><span class="glyphicon glyphicon-chevron-right"></span></a>\n</div>\n')
}]), angular.module("template/carousel/slide.html", []).run(["$templateCache", function (a) {
    a.put("template/carousel/slide.html", '<div ng-class="{\n    \'active\': active\n  }" class="item text-center" ng-transclude></div>\n')
}]), angular.module("template/datepicker/datepicker.html", []).run(["$templateCache", function (a) {
    a.put("template/datepicker/datepicker.html", '<div ng-switch="datepickerMode" role="application" ng-keydown="keydown($event)">\n  <daypicker ng-switch-when="day" tabindex="0"></daypicker>\n  <monthpicker ng-switch-when="month" tabindex="0"></monthpicker>\n  <yearpicker ng-switch-when="year" tabindex="0"></yearpicker>\n</div>')
}]), angular.module("template/datepicker/day.html", []).run(["$templateCache", function (a) {
    a.put("template/datepicker/day.html", '<table role="grid" aria-labelledby="{{::uniqueId}}-title" aria-activedescendant="{{activeDateId}}">\n  <thead>\n    <tr>\n      <th><button type="button" class="btn btn-default btn-sm pull-left" ng-click="move(-1)" tabindex="-1"><i class="glyphicon glyphicon-chevron-left"></i></button></th>\n      <th colspan="{{::5 + showWeeks}}"><button id="{{::uniqueId}}-title" role="heading" aria-live="assertive" aria-atomic="true" type="button" class="btn btn-default btn-sm" ng-click="toggleMode()" ng-disabled="datepickerMode === maxMode" tabindex="-1" style="width:100%;"><strong>{{title}}</strong></button></th>\n      <th><button type="button" class="btn btn-default btn-sm pull-right" ng-click="move(1)" tabindex="-1"><i class="glyphicon glyphicon-chevron-right"></i></button></th>\n    </tr>\n    <tr>\n      <th ng-if="showWeeks" class="text-center"></th>\n      <th ng-repeat="label in ::labels track by $index" class="text-center"><small aria-label="{{::label.full}}">{{::label.abbr}}</small></th>\n    </tr>\n  </thead>\n  <tbody>\n    <tr ng-repeat="row in rows track by $index">\n      <td ng-if="showWeeks" class="text-center h6"><em>{{ weekNumbers[$index] }}</em></td>\n      <td ng-repeat="dt in row track by dt.date" class="text-center" role="gridcell" id="{{::dt.uid}}" ng-class="::dt.customClass">\n        <button type="button" style="min-width:100%;" class="btn btn-default btn-sm" ng-class="{\'btn-info\': dt.selected, active: isActive(dt)}" ng-click="select(dt.date)" ng-disabled="dt.disabled" tabindex="-1"><span ng-class="::{\'text-muted\': dt.secondary, \'text-info\': dt.current}">{{::dt.label}}</span></button>\n      </td>\n    </tr>\n  </tbody>\n</table>\n')
}]), angular.module("template/datepicker/month.html", []).run(["$templateCache", function (a) {
    a.put("template/datepicker/month.html", '<table role="grid" aria-labelledby="{{::uniqueId}}-title" aria-activedescendant="{{activeDateId}}">\n  <thead>\n    <tr>\n      <th><button type="button" class="btn btn-default btn-sm pull-left" ng-click="move(-1)" tabindex="-1"><i class="glyphicon glyphicon-chevron-left"></i></button></th>\n      <th><button id="{{::uniqueId}}-title" role="heading" aria-live="assertive" aria-atomic="true" type="button" class="btn btn-default btn-sm" ng-click="toggleMode()" ng-disabled="datepickerMode === maxMode" tabindex="-1" style="width:100%;"><strong>{{title}}</strong></button></th>\n      <th><button type="button" class="btn btn-default btn-sm pull-right" ng-click="move(1)" tabindex="-1"><i class="glyphicon glyphicon-chevron-right"></i></button></th>\n    </tr>\n  </thead>\n  <tbody>\n    <tr ng-repeat="row in rows track by $index">\n      <td ng-repeat="dt in row track by dt.date" class="text-center" role="gridcell" id="{{::dt.uid}}" ng-class="::dt.customClass">\n        <button type="button" style="min-width:100%;" class="btn btn-default" ng-class="{\'btn-info\': dt.selected, active: isActive(dt)}" ng-click="select(dt.date)" ng-disabled="dt.disabled" tabindex="-1"><span ng-class="::{\'text-info\': dt.current}">{{::dt.label}}</span></button>\n      </td>\n    </tr>\n  </tbody>\n</table>\n')
}]), angular.module("template/datepicker/popup.html", []).run(["$templateCache", function (a) {
    a.put("template/datepicker/popup.html", '<ul class="dropdown-menu" ng-if="isOpen" style="display: block" ng-style="{top: position.top+\'px\', left: position.left+\'px\'}" ng-keydown="keydown($event)" ng-click="$event.stopPropagation()">\n	<li ng-transclude></li>\n	<li ng-if="showButtonBar" style="padding:10px 9px 2px">\n		<span class="btn-group pull-left">\n			<button type="button" class="btn btn-sm btn-info" ng-click="select(\'today\')">{{ getText(\'current\') }}</button>\n			<button type="button" class="btn btn-sm btn-danger" ng-click="select(null)">{{ getText(\'clear\') }}</button>\n		</span>\n		<button type="button" class="btn btn-sm btn-success pull-right" ng-click="close()">{{ getText(\'close\') }}</button>\n	</li>\n</ul>\n')
}]), angular.module("template/datepicker/year.html", []).run(["$templateCache", function (a) {
    a.put("template/datepicker/year.html", '<table role="grid" aria-labelledby="{{::uniqueId}}-title" aria-activedescendant="{{activeDateId}}">\n  <thead>\n    <tr>\n      <th><button type="button" class="btn btn-default btn-sm pull-left" ng-click="move(-1)" tabindex="-1"><i class="glyphicon glyphicon-chevron-left"></i></button></th>\n      <th colspan="3"><button id="{{::uniqueId}}-title" role="heading" aria-live="assertive" aria-atomic="true" type="button" class="btn btn-default btn-sm" ng-click="toggleMode()" ng-disabled="datepickerMode === maxMode" tabindex="-1" style="width:100%;"><strong>{{title}}</strong></button></th>\n      <th><button type="button" class="btn btn-default btn-sm pull-right" ng-click="move(1)" tabindex="-1"><i class="glyphicon glyphicon-chevron-right"></i></button></th>\n    </tr>\n  </thead>\n  <tbody>\n    <tr ng-repeat="row in rows track by $index">\n      <td ng-repeat="dt in row track by dt.date" class="text-center" role="gridcell" id="{{::dt.uid}}">\n        <button type="button" style="min-width:100%;" class="btn btn-default" ng-class="{\'btn-info\': dt.selected, active: isActive(dt)}" ng-click="select(dt.date)" ng-disabled="dt.disabled" tabindex="-1"><span ng-class="::{\'text-info\': dt.current}">{{::dt.label}}</span></button>\n      </td>\n    </tr>\n  </tbody>\n</table>\n')
}]), angular.module("template/modal/backdrop.html", []).run(["$templateCache", function (a) {
    a.put("template/modal/backdrop.html", '<div class="modal-backdrop"\n     modal-animation-class="fade"\n     modal-in-class="in"\n     ng-style="{\'z-index\': 1040 + (index && 1 || 0) + index*10}"\n></div>\n')
}]), angular.module("template/modal/window.html", []).run(["$templateCache", function (a) {
    a.put("template/modal/window.html", '<div modal-render="{{$isRendered}}" tabindex="-1" role="dialog" class="modal"\n    modal-animation-class="fade"\n    modal-in-class="in"\n	ng-style="{\'z-index\': 1050 + index*10, display: \'block\'}" ng-click="close($event)">\n    <div class="modal-dialog" ng-class="size ? \'modal-\' + size : \'\'"><div class="modal-content" modal-transclude></div></div>\n</div>\n')
}]), angular.module("template/pagination/pager.html", []).run(["$templateCache", function (a) {
    a.put("template/pagination/pager.html", '<ul class="pager">\n  <li ng-class="{disabled: noPrevious(), previous: align}"><a href ng-click="selectPage(page - 1, $event)">{{::getText(\'previous\')}}</a></li>\n  <li ng-class="{disabled: noNext(), next: align}"><a href ng-click="selectPage(page + 1, $event)">{{::getText(\'next\')}}</a></li>\n</ul>')
}]), angular.module("template/pagination/pagination.html", []).run(["$templateCache", function (a) {
    a.put("template/pagination/pagination.html", '<ul class="pagination">\n  <li ng-if="::boundaryLinks" ng-class="{disabled: noPrevious()||ngDisabled}" class="pagination-first"><a href ng-click="selectPage(1, $event)">{{::getText(\'first\')}}</a></li>\n  <li ng-if="::directionLinks" ng-class="{disabled: noPrevious()||ngDisabled}" class="pagination-prev"><a href ng-click="selectPage(page - 1, $event)">{{::getText(\'previous\')}}</a></li>\n  <li ng-repeat="page in pages track by $index" ng-class="{active: page.active,disabled: ngDisabled&&!page.active}" class="pagination-page"><a href ng-click="selectPage(page.number, $event)">{{page.text}}</a></li>\n  <li ng-if="::directionLinks" ng-class="{disabled: noNext()||ngDisabled}" class="pagination-next"><a href ng-click="selectPage(page + 1, $event)">{{::getText(\'next\')}}</a></li>\n  <li ng-if="::boundaryLinks" ng-class="{disabled: noNext()||ngDisabled}" class="pagination-last"><a href ng-click="selectPage(totalPages, $event)">{{::getText(\'last\')}}</a></li>\n</ul>\n')
}]), angular.module("template/tooltip/tooltip-html-popup.html", []).run(["$templateCache", function (a) {
    a.put("template/tooltip/tooltip-html-popup.html", '<div class="tooltip"\n  tooltip-animation-class="fade"\n  tooltip-classes\n  ng-class="{ in: isOpen() }">\n  <div class="tooltip-arrow"></div>\n  <div class="tooltip-inner" ng-bind-html="contentExp()"></div>\n</div>\n')
}]), angular.module("template/tooltip/tooltip-html-unsafe-popup.html", []).run(["$templateCache", function (a) {
    a.put("template/tooltip/tooltip-html-unsafe-popup.html", '<div class="tooltip"\n  tooltip-animation-class="fade"\n  tooltip-classes\n  ng-class="{ in: isOpen() }">\n  <div class="tooltip-arrow"></div>\n  <div class="tooltip-inner" bind-html-unsafe="content"></div>\n</div>\n')
}]), angular.module("template/tooltip/tooltip-popup.html", []).run(["$templateCache", function (a) {
    a.put("template/tooltip/tooltip-popup.html", '<div class="tooltip"\n  tooltip-animation-class="fade"\n  tooltip-classes\n  ng-class="{ in: isOpen() }">\n  <div class="tooltip-arrow"></div>\n  <div class="tooltip-inner" ng-bind="content"></div>\n</div>\n')
}]), angular.module("template/tooltip/tooltip-template-popup.html", []).run(["$templateCache", function (a) {
    a.put("template/tooltip/tooltip-template-popup.html", '<div class="tooltip"\n  tooltip-animation-class="fade"\n  tooltip-classes\n  ng-class="{ in: isOpen() }">\n  <div class="tooltip-arrow"></div>\n  <div class="tooltip-inner"\n    tooltip-template-transclude="contentExp()"\n    tooltip-template-transclude-scope="originScope()"></div>\n</div>\n')
}]), angular.module("template/popover/popover-html.html", []).run(["$templateCache", function (a) {
    a.put("template/popover/popover-html.html", '<div class="popover"\n  tooltip-animation-class="fade"\n  tooltip-classes\n  ng-class="{ in: isOpen() }">\n  <div class="arrow"></div>\n\n  <div class="popover-inner">\n      <h3 class="popover-title" ng-bind="title" ng-if="title"></h3>\n      <div class="popover-content" ng-bind-html="contentExp()"></div>\n  </div>\n</div>\n')
}]), angular.module("template/popover/popover-template.html", []).run(["$templateCache", function (a) {
    a.put("template/popover/popover-template.html", '<div class="popover"\n  tooltip-animation-class="fade"\n  tooltip-classes\n  ng-class="{ in: isOpen() }">\n  <div class="arrow"></div>\n\n  <div class="popover-inner">\n      <h3 class="popover-title" ng-bind="title" ng-if="title"></h3>\n      <div class="popover-content"\n        tooltip-template-transclude="contentExp()"\n        tooltip-template-transclude-scope="originScope()"></div>\n  </div>\n</div>\n')
}]), angular.module("template/popover/popover.html", []).run(["$templateCache", function (a) {
    a.put("template/popover/popover.html", '<div class="popover"\n  tooltip-animation-class="fade"\n  tooltip-classes\n  ng-class="{ in: isOpen() }">\n  <div class="arrow"></div>\n\n  <div class="popover-inner">\n      <h3 class="popover-title" ng-bind="title" ng-if="title"></h3>\n      <div class="popover-content" ng-bind="content"></div>\n  </div>\n</div>\n')
}]), angular.module("template/progressbar/bar.html", []).run(["$templateCache", function (a) {
    a.put("template/progressbar/bar.html", '<div class="progress-bar" ng-class="type && \'progress-bar-\' + type" role="progressbar" aria-valuenow="{{value}}" aria-valuemin="0" aria-valuemax="{{max}}" ng-style="{width: (percent < 100 ? percent : 100) + \'%\'}" aria-valuetext="{{percent | number:0}}%" style="min-width: 0;" ng-transclude></div>\n')
}]), angular.module("template/progressbar/progress.html", []).run(["$templateCache", function (a) {
    a.put("template/progressbar/progress.html", '<div class="progress" ng-transclude></div>')
}]), angular.module("template/progressbar/progressbar.html", []).run(["$templateCache", function (a) {
    a.put("template/progressbar/progressbar.html", '<div class="progress">\n  <div class="progress-bar" ng-class="type && \'progress-bar-\' + type" role="progressbar" aria-valuenow="{{value}}" aria-valuemin="0" aria-valuemax="{{max}}" ng-style="{width: (percent < 100 ? percent : 100) + \'%\'}" aria-valuetext="{{percent | number:0}}%" style="min-width: 0;" ng-transclude></div>\n</div>\n')
}]), angular.module("template/rating/rating.html", []).run(["$templateCache", function (a) {
    a.put("template/rating/rating.html", '<span ng-mouseleave="reset()" ng-keydown="onKeydown($event)" tabindex="0" role="slider" aria-valuemin="0" aria-valuemax="{{range.length}}" aria-valuenow="{{value}}">\n    <span ng-repeat-start="r in range track by $index" class="sr-only">({{ $index < value ? \'*\' : \' \' }})</span>\n    <i ng-repeat-end ng-mouseenter="enter($index + 1)" ng-click="rate($index + 1)" class="glyphicon" ng-class="$index < value && (r.stateOn || \'glyphicon-star\') || (r.stateOff || \'glyphicon-star-empty\')" ng-attr-title="{{r.title}}" ></i>\n</span>\n')
}]), angular.module("template/tabs/tab.html", []).run(["$templateCache", function (a) {
    a.put("template/tabs/tab.html", '<li ng-class="{active: active, disabled: disabled}">\n  <a href ng-click="select()" tab-heading-transclude>{{heading}}</a>\n</li>\n')
}]), angular.module("template/tabs/tabset.html", []).run(["$templateCache", function (a) {
    a.put("template/tabs/tabset.html", '<div>\n  <ul class="nav nav-{{type || \'tabs\'}}" ng-class="{\'nav-stacked\': vertical, \'nav-justified\': justified}" ng-transclude></ul>\n  <div class="tab-content">\n    <div class="tab-pane" \n         ng-repeat="tab in tabs" \n         ng-class="{active: tab.active}"\n         tab-content-transclude="tab">\n    </div>\n  </div>\n</div>\n')
}]), angular.module("template/timepicker/timepicker.html", []).run(["$templateCache", function (a) {
    a.put("template/timepicker/timepicker.html", '<table>\n  <tbody>\n    <tr class="text-center" ng-show="::showSpinners">\n      <td><a ng-click="incrementHours()" ng-class="{disabled: noIncrementHours()}" class="btn btn-link"><span class="glyphicon glyphicon-chevron-up"></span></a></td>\n      <td>&nbsp;</td>\n      <td><a ng-click="incrementMinutes()" ng-class="{disabled: noIncrementMinutes()}" class="btn btn-link"><span class="glyphicon glyphicon-chevron-up"></span></a></td>\n      <td ng-show="showMeridian"></td>\n    </tr>\n    <tr>\n      <td class="form-group" ng-class="{\'has-error\': invalidHours}">\n        <input style="width:50px;" type="text" ng-model="hours" ng-change="updateHours()" class="form-control text-center" ng-readonly="::readonlyInput" maxlength="2">\n      </td>\n      <td>:</td>\n      <td class="form-group" ng-class="{\'has-error\': invalidMinutes}">\n        <input style="width:50px;" type="text" ng-model="minutes" ng-change="updateMinutes()" class="form-control text-center" ng-readonly="::readonlyInput" maxlength="2">\n      </td>\n      <td ng-show="showMeridian"><button type="button" ng-class="{disabled: noToggleMeridian()}" class="btn btn-default text-center" ng-click="toggleMeridian()">{{meridian}}</button></td>\n    </tr>\n    <tr class="text-center" ng-show="::showSpinners">\n      <td><a ng-click="decrementHours()" ng-class="{disabled: noDecrementHours()}" class="btn btn-link"><span class="glyphicon glyphicon-chevron-down"></span></a></td>\n      <td>&nbsp;</td>\n      <td><a ng-click="decrementMinutes()" ng-class="{disabled: noDecrementMinutes()}" class="btn btn-link"><span class="glyphicon glyphicon-chevron-down"></span></a></td>\n      <td ng-show="showMeridian"></td>\n    </tr>\n  </tbody>\n</table>\n')
}]), angular.module("template/typeahead/typeahead-match.html", []).run(["$templateCache", function (a) {
    a.put("template/typeahead/typeahead-match.html", '<a href tabindex="-1" bind-html-unsafe="match.label | typeaheadHighlight:query"></a>\n')
}]), angular.module("template/typeahead/typeahead-popup.html", []).run(["$templateCache", function (a) {
    a.put("template/typeahead/typeahead-popup.html", '<ul class="dropdown-menu" ng-show="isOpen() && !moveInProgress" ng-style="{top: position().top+\'px\', left: position().left+\'px\'}" style="display: block;" role="listbox" aria-hidden="{{!isOpen()}}">\n    <li ng-repeat="match in matches track by $index" ng-class="{active: isActive($index) }" ng-mouseenter="selectActive($index)" ng-click="selectMatch($index)" role="option" id="{{::match.id}}">\n        <div typeahead-match index="$index" match="match" query="query" template-url="templateUrl"></div>\n    </li>\n</ul>\n')
}]), !angular.$$csp() && angular.element(document).find("head").prepend('<style type="text/css">.ng-animate.item:not(.left):not(.right){-webkit-transition:0s ease-in-out left;transition:0s ease-in-out left}</style>');
