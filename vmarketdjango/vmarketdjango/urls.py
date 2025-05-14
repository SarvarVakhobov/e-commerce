from django.conf import settings
from django.conf.urls.static import static
from django.contrib import admin
from django.urls import path, include
from django.http import JsonResponse

# Simple ping endpoint to test connectivity from mobile app
def ping_view(request):
    return JsonResponse({'status': 'ok', 'message': 'API server is running'})

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/v1/', include('djoser.urls')),
    path('api/v1/', include('djoser.urls.authtoken')),
    path('api/v1/', include('product.urls')),
    path('api/v1/', include('order.urls')),
    path('api/v1/ping/', ping_view, name='ping'),
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
