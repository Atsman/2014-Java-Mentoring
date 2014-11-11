APP.LinkCreateView = Backbone.View.extend({

    events: {
        "click button.save": "save"
    },

    // the constructor
    initialize: function(options) {
        this.link = options.link;
        this.links = options.links;
        this.link.bind('invalid', this.showErrors, this);
    },

    showErrors: function(note, errors) {
        this.$el.find('.error').removeClass('error');
        this.$el.find('.alert').html(_.values(errors).join('<br>')).show();
        // highlight the fields with errors
        _.each(_.keys(errors), _.bind(function(key) {
            this.$el.find('*[name=' + key + ']').parent().addClass('error');
        }, this));
    },

    save: function(event) {
        event.stopPropagation();
        event.preventDefault();
        this.link.set({
            title: this.$el.find('input[name=title]').val(),
            href: this.$el.find('input[name=href]').val(),
            target: this.$el.find('input[name=target]').val(),
            id: Math.floor(Math.random() * 100) + 1
        });
        if (this.link.isValid()) {
            this.links.add(this.link);
            window.location.hash = "link/index";
        }
    },

    render: function() {
        return this.$el.html(_.template($('#formTemplate').html(), this.link.toJSON())(this.link.toJSON()));
    }

});
