from rest_framework import serializers
from order.models import Order, OrderItem
from product.serializers import ProductSerializers

class OrderItemSerializer(serializers.ModelSerializer):
    class Meta:
        model = OrderItem
        fields = (
            'price',
            'product',
            'quantity',
        )

class OrderSerializer(serializers.ModelSerializer):
    items = OrderItemSerializer(many=True)

    class Meta:
        model = Order
        fields = (
            'id',
            'first_name',
            'last_name',
            'email',
            'address',
            'zipcode',
            'place',
            'phone',
            'stripe_token',
            'items',
        )

    def create(self, validated_date):
        items_data = validated_date.pop('items')
        order = Order.objects.create(**validated_date)

        for item_data in items_data:
            OrderItem.objects.create(order=order, **item_data)

        return order