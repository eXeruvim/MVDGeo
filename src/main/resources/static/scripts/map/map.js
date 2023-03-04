window.onload = init;

function init(){
    const map = new ol.Map({
        view: new ol.View({
            center: [5656800.656056675, 8779879.08967521],
            zoom: 11,
            minZoom: 1,
            maxZoom: 20,
            extent: [4854714.3144951835, 8111655.715037619, 7411648.638187531, 10715716.710836777],
        }),
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM({
                    source: new ol.source.OSM(),
                }),
                visible: true
            })
        ],
        keyboardEventTarget: document,
        target: 'map',
    })

    map.on('click', function (e){
        console.log(e.coordinate)
    })




    const KomiGeoJSON = new ol.layer.VectorImage({
        source: new ol.source.Vector({
            url: '/static/js/map/vector/map.geojson',
            format: new ol.format.GeoJSON()
        }),
        visible: true,
        title: 'Республика Коми',
    })

    // map.addLayer(KomiGeoJSON);
}

