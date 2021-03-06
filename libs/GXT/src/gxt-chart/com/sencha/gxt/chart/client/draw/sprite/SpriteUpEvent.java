/**
 * Sencha GXT 4.0.0 - Sencha for GWT
 * Copyright (c) 2006-2015, Sencha Inc.
 *
 * licensing@sencha.com
 * http://www.sencha.com/products/gxt/license/
 *
 * ================================================================================
 * Open Source License
 * ================================================================================
 * This version of Sencha GXT is licensed under the terms of the Open Source GPL v3
 * license. You may use this license only if you are prepared to distribute and
 * share the source code of your application under the GPL v3 license:
 * http://www.gnu.org/licenses/gpl.html
 *
 * If you are NOT prepared to distribute and share the source code of your
 * application under the GPL v3 license, other commercial and oem licenses
 * are available for an alternate download of Sencha GXT.
 *
 * Please see the Sencha GXT Licensing page at:
 * http://www.sencha.com/products/gxt/license/
 *
 * For clarification or additional options, please contact:
 * licensing@sencha.com
 * ================================================================================
 *
 *
 * ================================================================================
 * Disclaimer
 * ================================================================================
 * THIS SOFTWARE IS DISTRIBUTED "AS-IS" WITHOUT ANY WARRANTIES, CONDITIONS AND
 * REPRESENTATIONS WHETHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION THE
 * IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILITY, MERCHANTABLE QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, DURABILITY, NON-INFRINGEMENT, PERFORMANCE AND
 * THOSE ARISING BY STATUTE OR FROM CUSTOM OR USAGE OF TRADE OR COURSE OF DEALING.
 * ================================================================================
 */
package com.sencha.gxt.chart.client.draw.sprite;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.sencha.gxt.chart.client.draw.sprite.SpriteUpEvent.SpriteUpHandler;

/**
 * Fired when the mouse is released over a sprite in the draw component.
 */
public class SpriteUpEvent extends GwtEvent<SpriteUpHandler> {

  /**
   * A widget that implements this interface is a public source of
   * {@link SpriteUpEvent} events.
   */
  public interface HasSpriteUpHandlers {

    /**
     * Adds a {@link SpriteUpHandler} handler for {@link SpriteUpEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addSpriteUpHandler(SpriteUpHandler handler);
  }

  /**
   * Handler class for {@link SpriteUpEvent} events.
   */
  public interface SpriteUpHandler extends EventHandler {

    /**
     * Fired when the mouse is released over a {@link Sprite}.
     * 
     * @param event the fired event
     */
    void onSpriteUp(SpriteUpEvent event);
  }

  /**
   * Handler type.
   */
  private static Type<SpriteUpHandler> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<SpriteUpHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<SpriteUpHandler>();
    }
    return TYPE;
  }

  private final Sprite sprite;
  private final Event event;

  /**
   * Creates a new event with the given sprite.
   * 
   * @param sprite the sprite that caused the event
   */
  public SpriteUpEvent(Sprite sprite, Event event) {
    this.sprite = sprite;
    this.event = event;
  }

  @Override
  public Type<SpriteUpHandler> getAssociatedType() {
    return getType();
  }

  /**
   * Returns the browser event that initiated the selection event.
   * 
   * @return the browser event that initiated the selection event
   */
  public Event getBrowserEvent() {
    return event;
  }

  /**
   * Returns the sprite that caused the event.
   * 
   * @return the sprite that caused the event
   */
  public Sprite getSprite() {
    return sprite;
  }

  @Override
  protected void dispatch(SpriteUpHandler handler) {
    handler.onSpriteUp(this);
  }

}
